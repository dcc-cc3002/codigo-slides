package cl.uchile.dcc
package junit

import cl.uchile.dcc.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.{BeforeEach, DisplayName, Test}

/**
 * Ejemplo didáctico de JUnit 5.x.
 *
 * La slide 23 usa esta clase para mostrar la estructura básica de un test:
 * importar el framework, preparar un fixture con `@BeforeEach` y marcar un
 * método de prueba con `@Test`.
 */
class CalculatorTest:

  /**
   * Fixture del test.
   *
   * Se deja como `Option` porque se inicializa en `setUp`, no al declarar el
   * atributo.
   */
  var calculator: Option[Calculator] = None

  /**
   * Slide 23: `@BeforeEach` ejecuta este método antes de cada test.
   *
   * Así cada prueba parte con una calculadora nueva y no comparte estado con
   * las demás.
   */
  @BeforeEach
  def setUp(): Unit =
    calculator = Some(new Calculator())

  /**
   * Slide 23: `@Test` marca la lógica de la prueba y `@DisplayName` entrega
   * una descripción legible en el runner.
   *
   * Este caso verifica que `add(2, 3)` produzca `5`.
   */
  @Test
  @DisplayName("Test addition of two numbers")
  def testAddition(): Unit =
    assertEquals(5, calculator.get.add(2, 3), "2 + 3")
