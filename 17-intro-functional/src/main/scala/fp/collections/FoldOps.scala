package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

trait FoldOps[A]:
  def foldLeft[B](initial: B)(combine: (B, A) => B): B
  def foldRight[B](initial: B)(combine: (A, B) => B): B

@main def foldExample(): Unit =
  val planToRead =
    List("Pluto" -> 65, "Hokuto no Ken" -> 245, "Uzumaki" -> 19)
  planToRead
    .foldLeft(0)((acc, item) => acc + item._2)
    .tap(println) // 329
  planToRead
    .foldRight(0)((item, acc) => acc + item._2)
    .tap(println) // 329
  : Unit
