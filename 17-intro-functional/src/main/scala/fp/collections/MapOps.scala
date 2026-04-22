package cl.uchile.dcc
package fp.collections

/**
 * El trait `MapOps` no se utiliza en este ejemplo; se incluye únicamente
 * para transmitir la idea y la firma del método `map` que esperaríamos en
 * una abstracción de colecciones (por ejemplo: map[A => B]).
 */
trait MapOps[A]:
  def map[B](transform: A => B): Iterable[B]

@main def mapExample(): Unit =
  val ns = List(1, 2, 3)
  // Distintas formas de escribir la función que se pasa a `map`
  println(ns.map((n: Int) => n * n)) // función con tipo explícito
  println(ns.map(n => s"#$n"))       // parámetro nombrado
  println(ns.map(_.toString))        // sintaxis abreviada con placeholder
