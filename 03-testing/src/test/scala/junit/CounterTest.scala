package cl.uchile.dcc
package junit

import cl.uchile.dcc.Counter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.{BeforeEach, DisplayName, Test}

/**
 * Version en JUnit 5 del ejemplo de fixture mutable con `Counter`.
 *
 * Sirve para contrastar con MUnit que el aislamiento entre tests depende de
 * reinicializar el fixture antes de cada prueba, no del framework en si.
 */
class CounterTest:

  /** Se usa `Option` para evitar partir con `null` en el fixture. */
  var counter: Option[Counter] = None

  /** Cada test recibe un contador nuevo. */
  @BeforeEach
  def setUp(): Unit =
    counter = Some(new Counter())

  @Test
  @DisplayName("Counter incrementa una vez")
  def incrementOnce(): Unit =
    counter.get.increment()
    assertEquals(1, counter.get.current)

  @Test
  @DisplayName("Counter parte en cero")
  def startsAtZero(): Unit =
    assertEquals(0, counter.get.current)
