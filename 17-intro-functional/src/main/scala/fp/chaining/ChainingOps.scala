package cl.uchile.dcc
package fp.chaining

import scala.util.chaining.scalaUtilChainingOps

/**
 * Permite encadenar operaciones manteniendo el valor para efectos
 * laterales.
 *
 * Nota: este trait se usa solo con fines ilustrativos para mostrar la
 * firma de `tap`.
 */
trait ChainingOps[A]:
  def tap(sideEffect: A => Unit): A

@main def chainingExample(): Unit =
  // Encadenamos transformaciones y `tap` para ir observando el resultado parcial
  List(1, 2, 3)
    .map(_ * 2)
    .tap(println) // [2, 4, 6]
    .filter(_ > 2)
    .tap(println) // [4, 6]
    .sum
    .tap(sum => println(s"Final sum: $sum")): Unit
  // Final sum: 10
