package cl.uchile.dcc
package junit

import cl.uchile.dcc.Point
import org.junit.jupiter.api.Assertions.{assertEquals, assertNotEquals}
import org.junit.jupiter.api.{BeforeEach, DisplayName, Test}

/**
 * Version en JUnit 5 de los tests de `Point`.
 *
 * Mantiene el mismo foco didactico: probar un objeto pequeno usando
 * comportamiento, igualdad por estado y representacion textual.
 */
class PointTest:

  var origin: Option[Point] = None
  var sample: Option[Point] = None

  @BeforeEach
  def setUp(): Unit =
    origin = Some(new Point(0, 0))
    sample = Some(new Point(2, 3))

  @Test
  @DisplayName("Point puede moverse a una nueva posicion")
  def movePoint(): Unit =
    val moved = sample.get.moveBy(4, -1)
    assertEquals(new Point(6, 2), moved)

  @Test
  @DisplayName("Point usa igualdad por coordenadas")
  def comparePointsByState(): Unit =
    assertEquals(Some(new Point(2, 3)), sample)
    assertNotEquals(origin, sample)

  @Test
  @DisplayName("Point tiene una representacion textual legible")
  def hasReadableToString(): Unit =
    assertEquals("Point(0, 0)", origin.get.toString)
