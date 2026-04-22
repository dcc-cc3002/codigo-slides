package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

/**
 * Abstracción de `filter` basada en un predicado.
 *
 * Nota: este trait se usa solo con fines ilustrativos para mostrar la
 * firma de `filter`.
 */
trait FilterOps[A]:
  def filter(predicate: A => Boolean): Iterable[A]

@main def filterExample(): Unit =
  // Filtramos listas de distintos tipos usando funciones como predicados
  List(1, 2, 3)
    .filter(_ % 2 == 1) // [1, 3]
    .tap(println): Unit
  List("x", "y", "2", "3", "a")
    .filter(_.forall(_.isDigit)) // ["2", "3"]
    .tap(println): Unit
  val isEven: Int => Boolean = _ % 2 == 0 // predicado reutilizable
  List(1, 2, 3, 4)
    .filter(isEven) // [2, 4]
    .tap(println): Unit
