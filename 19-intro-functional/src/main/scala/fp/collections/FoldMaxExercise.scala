package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

object FoldMaxExercise:
  private def max(numbers: List[Int]): Int =
    numbers.foldLeft(0)((acc, n) => math.max(acc, n))

  @main def runMax(): Unit =
    max(List(1, 2, 3, 4, 5))
      .tap(println) // 5
    () // Para satisfacer al compilador
