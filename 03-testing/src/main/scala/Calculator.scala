package cl.uchile.dcc

/**
 * Calculadora mínima para los ejemplos de JUnit y MUnit.
 *
 * Las slides 23 y 24 usan esta clase para mostrar cómo un test sencillo guía
 * la implementación: primero escribimos la prueba y luego agregamos solo el
 * comportamiento necesario para que pase.
 */
class Calculator:
  def add(a: Int, b: Int): Int = a + b
