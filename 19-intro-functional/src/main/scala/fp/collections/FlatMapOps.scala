package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

/**
 * Abstracción del combinador `flatMap` para colecciones.
 *
 * Nota: este trait se usa solo con fines ilustrativos para mostrar la
 * firma de `flatMap`.
 */
trait FlatMapOps[A]:
  def flatMap[B](f: A => Iterable[B]): Iterable[B]

@main def flatMapExample(): Unit =
  // Cada entero se transforma en una lista de dos enteros y se aplanan los resultados
  List(1, 2, 3)
    .flatMap(x => List(x, x * 2))
    // map:      [[1,2], [2,4], [3,6]]
    // flatMap:  [1,2,2,4,3,6]
    .tap(println): Unit
