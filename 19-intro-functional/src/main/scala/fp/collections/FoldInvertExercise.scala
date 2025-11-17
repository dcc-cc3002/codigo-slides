package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

object FoldInvertExercise:
  private def invert[A](as: List[A]): List[A] =
    as.foldLeft(List.empty[A])((acc, a) => a :: acc)

  @main def runInvert(): Unit =
    invert(List(1, 2, 3, 4))
      .tap(println) // [4, 3, 2, 1]
    () // Para satisfacer al compilador
