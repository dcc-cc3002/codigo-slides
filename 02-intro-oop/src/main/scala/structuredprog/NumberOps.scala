package cl.uchile.dcc
package structuredprog

/**
 * Calcula la suma de los números del 1 al n (inclusivo).
 *
 * Este ejemplo demuestra el concepto de iteración usando un loop for. La
 * iteración repite una acción (sumar) bien definida para cada valor en el
 * rango especificado.
 *
 * @param n
 *   el límite superior del rango (inclusivo)
 * @return
 *   la suma de todos los enteros desde 1 hasta n
 */
def sumUpTo(n: Int): Int =
  var sum = 0
  for i <- 1 to n do sum += i
  sum

/**
 * Calcula el promedio de los números del 1 al n.
 *
 * Este ejemplo demuestra el concepto de descomposición en funciones. En
 * lugar de duplicar la lógica de iteración, reutilizamos la función
 * sumUpTo para calcular la suma, y luego componemos la solución dividiendo
 * entre n. Así, average divide el problema en pasos bien definidos.
 *
 * @param n
 *   el número de elementos a promediar
 * @return
 *   el promedio de los números desde 1 hasta n
 */
def average(n: Int): Double =
  sumUpTo(n).toDouble / n
