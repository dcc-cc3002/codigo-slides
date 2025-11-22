package cl.uchile.dcc
package forcomprehensions.translation

import cl.uchile.dcc.forcomprehensions.queries.BookQueries

/** Helpers que definen map/flatMap/filter en términos de for. */
object TranslationExamples:
  def mapIter[A, B](xs: Iterable[A])(f: A => B): Iterable[B] =
    for x <- xs yield f(x)

  def flatMapIter[A, B](
      xs: Iterable[A]
  )(f: A => Iterable[B]): Iterable[B] =
    for
      x <- xs
      y <- f(x)
    yield y

  def filterIter[A](xs: Iterable[A])(pred: A => Boolean): Iterable[A] =
    for x <- xs if pred(x) yield x

  /** Ejemplo de for simple y su traducción a map. */
  private def forSimple[A, B](xs: Iterable[A], f: A => B): Iterable[B] =
    for x <- xs yield f(x)

  /** Traducción del ejemplo de pares primos con withFilter/map. */
  private def translatedPrimePairs(n: Int): List[(Int, Int)] =
    (1 until n).toList
      .flatMap(i =>
        (1 until i)
          .withFilter(j => isPrime(i + j))
          .map(j => (i, j))
      )

  /** Función auxiliar de primalidad solo para este ejemplo. */
  private def isPrime(n: Int): Boolean =
    (2 until n).forall(n % _ != 0)

  /** for imperativo que imprime títulos de libros. */
  private def imperativePrintBooks(): Unit =
    for book <- BookQueries.books do println(book.title)

  /** Misma idea usando foreach. */
  private def foreachPrintBooks(): Unit =
    BookQueries.books.foreach(book => println(book.title))

  @main def translationRunner(): Unit =
    println(forSimple(List(1, 2, 3), (x: Int) => x * 2))
    println(translatedPrimePairs(10))
    println("--- imperative for ---")
    imperativePrintBooks()
    println("--- foreach ---")
    foreachPrintBooks()
