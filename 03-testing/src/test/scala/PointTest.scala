package cl.uchile.dcc

/**
 * Slide 51: ejercicio de ejemplo para practicar MUnit con una clase pequeña.
 *
 * El fixture usa `Option` y los tests se apoyan en `toString`, `equals` y un
 * comportamiento simple de `moveBy`.
 */
class PointTest extends munit.FunSuite:
  var origin: Option[Point] = None
  var sample: Option[Point] = None

  override def beforeEach(context: BeforeEach): Unit =
    origin = Some(new Point(0, 0))
    sample = Some(new Point(2, 3))

  test("Point puede moverse a una nueva posicion"):
    val moved = sample.get.moveBy(4, -1)
    assertEquals(moved, new Point(6, 2))

  test("Point usa igualdad por coordenadas"):
    assertEquals(sample, Some(new Point(2, 3)))
    assertNotEquals(sample, origin)

  test("Point tiene una representacion textual legible"):
    assertEquals(origin.get.toString, "Point(0, 0)")
