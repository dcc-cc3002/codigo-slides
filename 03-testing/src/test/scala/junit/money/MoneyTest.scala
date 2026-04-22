package cl.uchile.dcc
package junit.money

import cl.uchile.dcc.money.{Money, MoneyBag}
import org.junit.jupiter.api.Assertions.{assertEquals, assertNotEquals}
import org.junit.jupiter.api.{BeforeEach, DisplayName, Test}

/**
 * Version en JUnit 5 de los tests base de `Money`.
 *
 * Conserva el mismo caso de estudio para mostrar igualdad por estado y suma
 * entre montos de una misma divisa.
 */
class MoneyTest:

  var _12clp: Option[Money] = None
  var _14clp: Option[Money] = None
  var _7usd: Option[Money] = None
  var _21usd: Option[Money] = None
  var _mb1: Option[MoneyBag] = None
  var _mb2: Option[MoneyBag] = None

  @BeforeEach
  def setUp(): Unit =
    _12clp = Some(new Money(12, "CLP"))
    _14clp = Some(new Money(14, "CLP"))
    _7usd = Some(new Money(7, "USD"))
    _21usd = Some(new Money(21, "USD"))
    _mb1 = Some(new MoneyBag(_12clp.get, _7usd.get))
    _mb2 = Some(new MoneyBag(_14clp.get, _21usd.get))

  @Test
  @DisplayName("Igualdad de dos objetos Money con mismo monto y divisa")
  def compareMoneyByState(): Unit =
    assertEquals(_12clp, _12clp)
    assertEquals(Some(new Money(12, "CLP")), _12clp)
    assertNotEquals(_14clp, _12clp)

  @Test
  @DisplayName("Money puede sumarse con otro objeto de la misma divisa")
  def addMoneyWithSameCurrency(): Unit =
    val expected = new Money(26, "CLP")
    val result = _12clp.get.add(_14clp.get)
    assertEquals(expected, result)
