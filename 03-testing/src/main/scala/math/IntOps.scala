package cl.uchile.dcc
package math

/**
 * Operaciones simples sobre enteros usadas para discutir testing por
 * particionado.
 *
 * En las slides 15 y 16, este trait sirve como punto de partida para
 * identificar subdominios de entrada y elegir casos de prueba
 * representativos en vez de intentar probar todos los enteros.
 */
trait IntOps:
  /**
   * Ejemplo de la slide 15.
   *
   * El comportamiento depende del signo de `n`, así que el particionado
   * natural considera los subdominios `n > 0`, `n < 0` y `n == 0`.
   */
  def abs(n: Int): Int

  /**
   * Ejemplo de la slide 16.
   *
   * El comportamiento depende de la relación entre `a` y `b`, por lo que
   * conviene probar casos con `a < b`, `a > b` y `a == b`.
   */
  def max(a: Int, b: Int): Int
