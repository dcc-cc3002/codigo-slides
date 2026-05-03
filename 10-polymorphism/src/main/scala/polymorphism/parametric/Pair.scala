package cl.uchile.dcc
package polymorphism.parametric

/**
 * Slides 24-25: un par puede tener dos tipos distintos.
 *
 * `A` describe el tipo del valor izquierdo y `B` el tipo del valor
 * derecho.
 */
class Pair[A, B](val left: A, val right: B):
  def swap(): Pair[B, A] = new Pair(right, left)

  override def toString: String =
    s"Pair($left, $right)"

@main def pairExample(): Unit =
  val pair: Pair[String, Int] = new Pair("age", 30)
  val swapped: Pair[Int, String] = pair.swap()

  println(pair)
  println(swapped)
