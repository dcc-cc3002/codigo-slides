package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

object FoldMapExercise:
  private def foldMap[A, B](as: List[A])(f: A => B): List[B] =
    as.foldRight(List.empty[B])((a, acc) => f(a) :: acc)

  @main def runFoldMap(): Unit =
    foldMap(List(1, 2, 3, 4))(_ * 2)
      .tap(println) // [2, 4, 6, 8]
    () // Para satisfacer al compilador
