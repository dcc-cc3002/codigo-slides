package cl.uchile.dcc
package money

/**
 * Slides 30 y 31: primeros tests del caso de estudio de aritmética de divisas.
 *
 * Aquí el fixture prepara montos base y las pruebas revisan igualdad y suma en
 * la misma divisa.
 */
class MoneyTest extends munit.FunSuite:
  var _12clp: Option[Money] = None
  var _14clp: Option[Money] = None
  var _7usd: Option[Money] = None
  var _21usd: Option[Money] = None
  var _mb1: Option[MoneyBag] = None
  var _mb2: Option[MoneyBag] = None

  override def beforeEach(context: BeforeEach): Unit =
    _12clp = Some(new Money(12, "CLP"))
    _14clp = Some(new Money(14, "CLP"))
    _7usd = Some(new Money(7, "USD"))
    _21usd = Some(new Money(21, "USD"))
    _mb1 = Some(new MoneyBag(_12clp.get, _7usd.get))
    _mb2 = Some(new MoneyBag(_14clp.get, _21usd.get))

  test("Igualdad de dos objetos Money con mismo monto y divisa"):
    assertEquals(_12clp, _12clp)
    assertEquals(_12clp, Some(new Money(12, "CLP")))
    assertNotEquals(_12clp, _14clp)

  test("Money puede sumarse con otro objeto de la misma divisa"):
    val expected = new Money(26, "CLP")
    val result = _12clp.get.add(_14clp.get)
    assertEquals(expected, result)
