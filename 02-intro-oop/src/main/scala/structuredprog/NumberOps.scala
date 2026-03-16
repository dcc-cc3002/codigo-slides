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

/**
 * Solución del ejercicio propuesto: suma recursiva sin estado mutable.
 *
 * Esta es la solución al ejercicio de reescribir sumUpTo sin estado mutable.
 * En lugar de usar un loop for con una variable mutable `sum`, utilizamos
 * recursión para acumular el resultado. La recursión es una alternativa a la
 * iteración que no requiere estado mutable: cada llamada recursiva reduce el
 * problema a uno más pequeño, hasta alcanzar el caso base (n = 0).
 *
 * Caso base: sumUpToRecursive(0) = 0
 * Caso recursivo: sumUpToRecursive(n) = n + sumUpToRecursive(n - 1)
 *
 * @param n
 *   el límite superior del rango (inclusivo)
 * @return
 *   la suma de todos los enteros desde 1 hasta n
 */
def sumUpToRecursive(n: Int): Int =
  if n <= 0 then 0
  else n + sumUpToRecursive(n - 1)

/**
 * Calcula el promedio usando la versión recursiva sin estado mutable.
 *
 * @param n
 *   el número de elementos a promediar
 * @return
 *   el promedio de los números desde 1 hasta n
 */
def averageRecursive(n: Int): Double =
  sumUpToRecursive(n).toDouble / n
