package cl.uchile.dcc

/**
 * Slides 26 y 27: ejemplo de cómo `beforeEach` evita contaminación entre
 * tests cuando el fixture es mutable.
 */
class CounterTest extends munit.FunSuite:
  /** Se usa `Option` para evitar partir con `null` en el fixture. */
  var counter: Option[Counter] = None

  /** Slide 27: cada test recibe un contador nuevo. */
  override def beforeEach(context: BeforeEach): Unit =
    counter = Some(new Counter())

  test("incrementa una vez"):
    counter.get.increment()
    assertEquals(counter.get.current, 1)

  test("parte en cero"):
    assertEquals(counter.get.current, 0)
