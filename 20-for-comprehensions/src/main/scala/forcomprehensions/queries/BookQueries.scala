package cl.uchile.dcc
package forcomprehensions.queries

/** Libro con título y autores. */
case class Book(title: String, authors: String*)

object BookQueries:
  /** Mini "base de datos" de libros. */
  val books: List[Book] = List(
      Book(
          title = "Structure and Interpretation of Computer Programs",
          authors = "Abelson, Harold",
          "Sussman, Gerald J."
      ),
      Book(
          title = "Introduction to Functional Programming",
          authors = "Bird, Richard",
          "Wadler, Phil"
      ),
      Book(title = "Effective Java", authors = "Bloch, Joshua"),
      Book(
          title = "Java Puzzlers",
          authors = "Bloch, Joshua",
          "Gafter, Neal"
      ),
      Book(
          title = "Programming in Scala",
          authors = "Odersky, Martin",
          "Spoon, Lex",
          "Venners, Bill"
      )
  )

  /** Títulos de libros cuyos autores empiezan con un prefijo. */
  private def titlesByAuthorPrefix(prefix: String): List[String] =
    for
      b <- books
      a <- b.authors if a.startsWith(prefix)
    yield b.title

  /** Títulos que contienen una palabra dada. */
  private def titlesContaining(word: String): List[String] =
    for b <- books if b.title.contains(word)
    yield b.title

  /** Autores que tienen al menos dos libros en la base. */
  private def authorsWithAtLeastTwoBooks(): List[String] =
    for
      b1 <- books
      b2 <- books if b1 != b2 && b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors if a1 == a2
    yield a1

  /** Igual que la anterior pero sin duplicados. */
  private def authorsWithAtLeastTwoBooksDistinct(): List[String] =
    authorsWithAtLeastTwoBooks().distinct

  @main def bookQueriesRunner(): Unit =
    println("Books by Bird: " + titlesByAuthorPrefix("Bird,"))
    println("Books containing 'Program': " + titlesContaining("Program"))
    val atLeastTwo = authorsWithAtLeastTwoBooksDistinct()
    println("Authors with >= 2 books: " + atLeastTwo.mkString("; "))
