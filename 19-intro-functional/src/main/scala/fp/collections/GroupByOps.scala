package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

trait GroupByOps[V]:
  def groupBy[K](f: V => K): Map[K, Iterable[V]]

@main def groupByExample(): Unit =
  val pf: PartialFunction[(Char, Iterable[String]),
                          (Char, Iterable[String])
  ] =
    case (key, values) => (key, values.map(_.toUpperCase))
  List("apple", "banana", "avocado", "blueberry")
    .groupBy(_.head)
    .tap(println) // { a -> [apple, avocado], b -> [banana, blueberry] }
    .collect(pf)
    .tap(println) // { a -> [APPLE, AVOCADO], b -> [BANANA, BLUEBERRY] }
  () // Para satisfacer al compilador
