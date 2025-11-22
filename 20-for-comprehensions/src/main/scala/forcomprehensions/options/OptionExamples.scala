package cl.uchile.dcc
package forcomprehensions.options

/** Suma segura de Option[Int] usando for. */
object OptionExamples:
  private def addOptions(x: Option[Int], y: Option[Int]): Option[Int] =
    for
      v1 <- x
      v2 <- y
    yield v1 + v2

  /** Wrapper simple para parámetros de request. */
  private case class RequestParams(params: Map[String, String]):
    def getParameter(key: String): Option[String] = params.get(key)

  /** Conversión segura de String a Int. */
  private def safeToInt(s: String): Option[Int] =
    try Some(s.toInt)
    catch case _: NumberFormatException => None

  /** Devuelve el trabajo solo si la persona es adulta. */
  private def jobIfAdult(params: RequestParams): Option[String] =
    for
      name <- params.getParameter("name")
      ageStr <- params.getParameter("age")
      age <- safeToInt(ageStr)
      job <- params.getParameter("job") if age > 18
    yield job

  /**
   * Versión simplificada de Option para ilustrar map/flatMap/withFilter.
   */
  sealed trait MyOption[+A]:
    self => // Alias para referirse a this dentro de la clase, mira (1)
    def isEmpty: Boolean
    def get: A

    def map[B](f: A => B): MyOption[B] =
      if isEmpty then MyNone else MySome(f(get))

    def flatMap[B](f: A => MyOption[B]): MyOption[B] =
      if isEmpty then MyNone else f(get)

    def foreach[U](f: A => U): Unit =
      if isEmpty then f(get): Unit else ()

    def withFilter(p: A => Boolean): WithFilter =
      new WithFilter(p)

    /** Implementación anidada como en las slides. */
    class WithFilter(p: A => Boolean):
      def map[B](f: A => B): MyOption[B] =
        // (1) Si no hubiéramos definido el alias para el `this` de
        // `MyOption` no tendríamos cómo referenciar la clase contenedora
        self.filter(p).map(f)

      def flatMap[B](f: A => MyOption[B]): MyOption[B] =
        self.filter(p).flatMap(f)

      def foreach[U](f: A => U): Unit =
        self.filter(p).foreach(f)

      def withFilter(q: A => Boolean): WithFilter =
        new WithFilter(x => p(x) && q(x))

    /** Filtro auxiliar usado por WithFilter. */
    def filter(p: A => Boolean): MyOption[A] =
      if isEmpty || !p(get) then MyNone else this

  final private case class MySome[+A](value: A) extends MyOption[A]:
    def isEmpty: Boolean = false
    def get: A = value

  private case object MyNone extends MyOption[Nothing]:
    def isEmpty: Boolean = true
    def get: Nothing = throw new NoSuchElementException("MyNone.get")

  /** Ejemplo de uso de MyOption con for. */
  private def myAdd(x: MyOption[Int], y: MyOption[Int]): MyOption[Int] =
    for
      v1 <- x
      v2 <- y
    yield v1 + v2

  @main def optionRunner(): Unit =
    println(addOptions(Some(1), Some(2)))
    println(addOptions(Some(1), None))

    val params = RequestParams(
        Map(
            "name" -> "Rudo",
            "age" -> "16",
            "job" -> "Scavenger"
        )
    )
    println(jobIfAdult(params))

    println(myAdd(MySome(1), MySome(2)))
    println(myAdd(MySome(1), MyNone))
