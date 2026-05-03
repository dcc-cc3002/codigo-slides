package cl.uchile.dcc
package polymorphism.adhoc

class Point(val x: Int, val y: Int)

class Triangle(val a: Point, val b: Point, val c: Point)

object Painter:
  /**
   * Slides 5-7: mismo nombre, distinta lista de parámetros.
   *
   * Esto es polimorfismo ad hoc mediante overloading. No hay una jerarquía
   * entre `Point` y `Triangle`; el compilador elige que método llamar
   * usando el tipo estático del argumento.
   */
  def paint(point: Point): String =
    s"Painting point (${point.x}, ${point.y})"

  def paint(triangle: Triangle): String =
    val a = triangle.a
    val b = triangle.b
    val c = triangle.c
    s"Painting triangle (${a.x}, ${a.y}), (${b.x}, ${b.y}), (${c.x}, ${c.y})"

@main def overloadingExample(): Unit =
  val point = new Point(1, 2)
  val triangle =
    new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, 3))

  println(Painter.paint(point))
  println(Painter.paint(triangle))
