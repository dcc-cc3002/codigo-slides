package cl.uchile.dcc
package junit.money

import cl.uchile.dcc.money.{Money, MoneyBag}
import org.junit.jupiter.api.Assertions.{assertEquals, assertNotEquals}
import org.junit.jupiter.api.{BeforeEach, DisplayName, Test}

/**
 * Version en JUnit 5 de los tests de igualdad sobre `MoneyBag`.
 *
 * Mantiene el foco en propiedades basicas de igualdad sin adelantar la suma
 * entre distintas divisas.
 */
class MoneyBagTest:

  var _mb1: Option[MoneyBag] = None
  var _mb2: Option[MoneyBag] = None
  var _mb3: Option[MoneyBag] = None
  var _mb4: Option[MoneyBag] = None
  var _12clp: Option[Money] = None
  var _14clp: Option[Money] = None
  var _7usd: Option[Money] = None
  var _21usd: Option[Money] = None

  @BeforeEach
  def setUp(): Unit =
    _12clp = Some(new Money(12, "CLP"))
    _14clp = Some(new Money(14, "CLP"))
    _7usd = Some(new Money(7, "USD"))
    _21usd = Some(new Money(21, "USD"))
    _mb1 = Some(new MoneyBag(_12clp.get, _7usd.get))
    _mb2 = Some(new MoneyBag(_14clp.get, _21usd.get))
    _mb3 = Some(new MoneyBag(new Money(12, "CLP"), new Money(7, "USD")))
    _mb4 = Some(new MoneyBag(new Money(7, "USD"), new Money(12, "CLP")))

  @Test
  @DisplayName("Igualdad reflexiva de MoneyBag")
  def reflexiveEquality(): Unit =
    assertEquals(_mb1, _mb1)

  @Test
  @DisplayName("Igualdad simetrica de MoneyBag")
  def symmetricEquality(): Unit =
    assertEquals(_mb1, _mb3)
    assertEquals(_mb3, _mb1)

  @Test
  @DisplayName("Igualdad transitiva de MoneyBag")
  def transitiveEquality(): Unit =
    assertEquals(_mb1, _mb3)
    assertEquals(_mb3, _mb4)
    assertEquals(_mb1, _mb4)

  @Test
  @DisplayName("Bolsas distintas no son iguales")
  def differentBagsAreNotEqual(): Unit =
    assertNotEquals(_mb2, _mb1)
