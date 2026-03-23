package cl.uchile.dcc
package money

/**
 * Slides 40, 41 y 49: tests para `MoneyBag` con fixtures basados en
 * `Option`.
 *
 * La igualdad se prueba como relación entre objetos, no solo como
 * comparación puntual entre dos instancias.
 */
class MoneyBagTest extends munit.FunSuite:
  var _mb1: Option[MoneyBag] = None
  var _mb2: Option[MoneyBag] = None
  var _mb3: Option[MoneyBag] = None
  var _mb4: Option[MoneyBag] = None
  var _12clp: Option[Money] = None
  var _14clp: Option[Money] = None
  var _7usd: Option[Money] = None
  var _21usd: Option[Money] = None

  override def beforeEach(context: BeforeEach): Unit =
    _12clp = Some(new Money(12, "CLP"))
    _14clp = Some(new Money(14, "CLP"))
    _7usd = Some(new Money(7, "USD"))
    _21usd = Some(new Money(21, "USD"))
    _mb1 = Some(new MoneyBag(_12clp.get, _7usd.get))
    _mb2 = Some(new MoneyBag(_14clp.get, _21usd.get))
    _mb3 = Some(new MoneyBag(new Money(12, "CLP"), new Money(7, "USD")))
    _mb4 = Some(new MoneyBag(new Money(7, "USD"), new Money(12, "CLP")))

  test("Igualdad reflexiva de MoneyBag"):
    assertEquals(_mb1, _mb1)

  test("Igualdad simétrica de MoneyBag"):
    assertEquals(_mb1, _mb3) // a == b
    assertEquals(_mb3, _mb1) // <==> b == a

  test("Igualdad transitiva de MoneyBag"):
    assertEquals(_mb1, _mb3) // a == b
    assertEquals(_mb3, _mb4) // && b == c
    assertEquals(_mb1, _mb4) // <==> a == c

  test("Bolsas distintas no son iguales"):
    assertNotEquals(_mb1, _mb2)

  /*
   * Slide 50: este test anticipa la suma entre distintas divisas.
   *
   * Queda pendiente porque aún no hemos visto double dispatch en el curso.
   *
   * test("Money puede sumarse con otro de distinta divisa"):
   *   val bag = Set(_12clp.get, _7usd.get)
   *   val expected = new MoneyBag(bag)
   *   assertEquals(expected, _12clp.get.add(_7usd.get))
   */
