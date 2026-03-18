package cl.uchile.dcc

/**
 * Contador mutable usado para ilustrar contaminación entre tests.
 *
 * Las slides 26 y 27 muestran que compartir este objeto entre pruebas
 * puede hacer que el resultado dependa del orden de ejecución.
 */
class Counter:
  var value = 0

  def increment(): Unit =
    value += 1

  def current: Int = value
