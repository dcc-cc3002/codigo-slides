package cl.uchile.dcc
package forcomprehensions.basics

/** Ejemplos básicos de for comprehensions sobre listas. */
case class Person(name: String, age: Int)

object BasicsExamples:
  // Lista de ejemplo
  private val persons: List[Person] = List(
      Person("Michael Stipe", 63),
      Person("Peter Buck", 68),
      Person("Mike Mills", 65),
      Person("Bill Berry", 65)
  )

  /** Usa filter + map para obtener nombres de adultos. */
  private def adultsNamesFilterMap(ps: List[Person]): List[String] =
    ps
      .filter(p => p.age >= 18)
      .map(p => p.name)

  /** Misma consulta pero usando una for-comprehension. */
  private def adultsNamesFor(ps: List[Person]): List[String] =
    for
      p <- ps
      if p.age >= 18
    yield p.name

  /** Prueba de divisores para saber si un número es primo. */
  private def isPrime(n: Int): Boolean =
    (for d <- 2 until n if n % d == 0 yield d).isEmpty

  /** Versión con flatMap / filter / map como en las slides. */
  private def primePairsFlatMap(n: Int): List[(Int, Int)] =
    (1 until n).toList
      .flatMap(i =>
        (1 until i)
          .filter(j => isPrime(i + j))
          .map(j => (i, j))
      )

  /** Misma idea pero escrita como for-comprehension. */
  private def primePairsFor(n: Int): Seq[(Int, Int)] =
    for
      i <- 1 until n
      j <- 1 until i
      if isPrime(i + j)
    yield (i, j)

  /** Producto escalar usando zip + map + sum. */
  private def scalarProduct(xs: List[Double], ys: List[Double]): Double =
    xs
      .zip(ys)
      .map((x, y) => x * y)
      .sum

  /** Producto escalar escrito con for. */
  private def scalarProductFor(xs: List[Double],
                               ys: List[Double]
  ): Double =
    (for (x, y) <- xs.zip(ys) yield x * y).sum

  @main def basicsRunner(): Unit =
    println("Adults (filter/map): " + adultsNamesFilterMap(persons))
    println("Adults (for): " + adultsNamesFor(persons))
    println("Prime pairs flatMap up to 10: " + primePairsFlatMap(10))
    println("Prime pairs for up to 10: " + primePairsFor(10))
    println(
        "Scalar product: " + scalarProduct(List(1, 2, 3), List(4, 5, 6))
    )
    println(
        "Scalar product (for): " + scalarProductFor(List(1, 2, 3),
                                                    List(4, 5, 6)
        )
    )
