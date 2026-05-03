package cl.uchile.dcc
package polymorphism.parametric.fbound

/**
 * Slide 32: contrato genérico para objetos escalables.
 *
 * `SELF` representa el tipo concreto que debe devolver `scale`. Asi,
 * escalar un `Point` devuelve otro `Point`, y escalar un `Circle` devuelve
 * otro `Circle`.
 */
trait Scalable[SELF]:
  def scale(factor: Double): SELF

class Point(val x: Double, val y: Double) extends Scalable[Point]:
  override def scale(factor: Double): Point =
    Point(x * factor, y * factor)

  override def toString: String =
    s"Point($x, $y)"

class Circle(val center: Point, val radius: Double)
    extends Scalable[Circle]:
  override def scale(factor: Double): Circle =
    Circle(center.scale(factor), radius * factor)

  override def toString: String =
    s"Circle($center, $radius)"

/**
 * Slides 33-34: el límite superior restringe `SELF`.
 *
 * Sin `SELF <: Scalable[SELF]`, el compilador no podría saber que `value`
 * tiene un método `scale`. La cota expresa que el tipo usado por `Scaler`
 * debe cumplir el contrato `Scalable`.
 */
class Scaler[SELF <: Scalable[SELF]]:
  def doubleSize(value: SELF): SELF =
    value.scale(2.0)

@main def scalerExample(): Unit =
  val pointScaler = new Scaler[Point]
  val circleScaler = new Scaler[Circle]

  println(pointScaler.doubleSize(new Point(1.0, 2.0)))
  println(circleScaler.doubleSize(new Circle(new Point(1.0, 1.0), 4.0)))
