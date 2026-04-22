package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

trait ZipOps[A]:
  def zip[B](that: Iterable[B]): Iterable[(A, B)]
  def zipWithIndex: Iterable[(A, Int)]

@main def zipExample(): Unit =
  val comics = List("Spawn", "TWD", "Fables", "Batman")
    .tap(c => println(s"# comics: ${c.length}")) // 4
  val authors = List("McFarlane", "Kirkman", "Willingham")
    .tap(a => println(s"# authors: ${a.length}")) // 3
  comics
    .zip(authors) // List[(String, String)]
    .tap(pairs => println(s"# pairs: ${pairs.length}")) // min(4, 3) = 3
    // [Spawn -> McFarlane, TWD -> Kirkman, Fables -> Willingham]
    .tap(println)
  authors.zipWithIndex
    .tap(println) // [McFarlane -> 0, Kirkman -> 1, Willingham -> 2]
    .foldLeft("")((acc, pair) =>
      val lastIndex = authors.length - 1
      pair match
        case (author, 0)                   => author
        case (author, i) if i == lastIndex => s"$acc y $author"
        case (author, _)                   => s"$acc, $author"
    )
    .tap(println) // McFarlane, Kirkman y Willingham
  () // Para satisfacer al compilador
