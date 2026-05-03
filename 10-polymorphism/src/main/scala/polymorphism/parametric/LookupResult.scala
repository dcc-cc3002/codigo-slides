package cl.uchile.dcc
package polymorphism.parametric

/**
 * Slides 26-27: resultado genérico de una búsqueda.
 *
 * `T` representa el tipo del valor que esperábamos encontrar. Si la
 * búsqueda tiene éxito, `Found[T]` contiene un valor de ese tipo. Si
 * falla, `Missing[T]` conserva la información del tipo esperado aunque no
 * tenga ningún valor guardado.
 */
trait LookupResult[T]:
  def isFound: Boolean

  def get: T

  /**
   * Slide 30: `S >: T` permite entregar un valor por defecto más general
   * que T. Por ejemplo, si buscamos un `Circle`, el valor por defecto
   * puede ser un `Shape`, porque `Shape` es supertipo de `Circle`.
   */
  def getOrElse[S >: T](default: S): S

class Found[T](val value: T) extends LookupResult[T]:
  override def isFound: Boolean = true
  override def get: T = value
  override def getOrElse[S >: T](default: S): S = value

class Missing[T] extends LookupResult[T]:
  override def isFound: Boolean = false
  override def get: T = throw new NoSuchElementException("Missing.get")
  override def getOrElse[S >: T](default: S): S = default

trait Shape
class Circle extends Shape
class Rectangle(val width: Double, val height: Double) extends Shape

@main def lookupExample(): Unit =
  // Slide 28: la búsqueda esperaba un Circle, pero no encontró ninguno.
  val result: LookupResult[Circle] =
    new Missing[Circle]

  // Slide 30: gracias al bound, el valor por defecto puede ser Rectangle y el
  // resultado completo puede tratarse como Shape.
  val shape: Shape =
    result.getOrElse(new Rectangle(10.0, 20.0))

  println(shape)
