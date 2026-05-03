package cl.uchile.dcc
package polymorphism.parametric

/**
 * Slide 19: un trait genérico describe una estructura para cualquier T.
 */
trait ListOf[T]:
  def head: T
  def tail: ListOf[T]

/**
 * Slide 20: `ConsOf[T]` guarda una cabeza de tipo T y una cola del mismo
 * T.
 */
class ConsOf[T](_head: T, _tail: ListOf[T]) extends ListOf[T]:
  override def head: T =
    _head

  override def tail: ListOf[T] =
    _tail

/**
 * Slide 20: `NilOf[T]` representa la lista vacia.
 *
 * Como no tiene cabeza ni cola, estas operaciones lanzan una excepción.
 * Esto mantiene el ejemplo pequeño para enfocarnos en parámetros de tipo.
 */
class NilOf[T] extends ListOf[T]:
  override def head: T =
    throw new NoSuchElementException("NilOf.head")

  override def tail: ListOf[T] =
    throw new NoSuchElementException("NilOf.tail")

@main def explicitGenericListExample(): Unit =
  // Slide 21: aquí escribimos los parámetros de tipo explícitamente.
  val numbers: ListOf[Int] =
    new ConsOf[Int](
        1,
        new ConsOf[Int](2, new ConsOf[Int](3, new NilOf[Int]))
    )

  println(numbers.tail.tail.head)

@main def inferredGenericListExample(): Unit =
  // Slide 22: el compilador puede inferir `Int` a partir de los valores.
  val numbers: ListOf[Int] =
    new ConsOf(1, new ConsOf(2, new ConsOf(3, new NilOf)))

  println(numbers.tail.tail.head)
