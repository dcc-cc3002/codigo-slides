//noinspection ScalaWeakerAccess
package cl.uchile.dcc
package fp.basics

/** Ejemplos de funciones puras y memoización. */
object PureFunctions:

  /**
   * Fibonacci como función pura con memoización explícita.
   *
   * @param n
   *   índice de Fibonacci a calcular (0‑based)
   * @param memo
   *   mapa de resultados ya calculados
   * @return
   *   un par `(resultado, nuevoMemo)` con el valor de `F(n)` y el mapa
   *   actualizado
   */
  def fibonacci(n: Int, memo: Map[Int, Int]): (Int, Map[Int, Int]) =
    memo.get(n) match
      case Some(value)    => (value, memo) // Si ya está calculado, reutilizamos el resultado
      case None if n <= 1 => (n, memo + (n -> n))
      case None =>
        val (a, memo1) = fibonacci(n - 1, memo)
        val (b, memo2) = fibonacci(n - 2, memo1)
        val result = a + b
        (result, memo2 + (n -> result))

  /** Versión conveniente que esconde el mapa de memoización. */
  def fibonacci(n: Int): Int =
    fibonacci(n, Map.empty)._1
