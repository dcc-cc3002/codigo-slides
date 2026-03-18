package cl.uchile.dcc

/**
 * Ejemplo didáctico de MUnit.
 *
 * La slide 24 usa esta clase para mostrar la forma básica de un test en
 * MUnit: extender `munit.FunSuite`, preparar el fixture sobreescribiendo
 * `beforeEach` y escribir un test con nombre descriptivo.
 */
class CalculatorTest extends munit.FunSuite:

  /**
   * Fixture del test.
   *
   * Se deja como `Option` porque se inicializa antes de cada prueba.
   */
  var calculator: Option[Calculator] = None

  /**
   * Slide 24: en MUnit no usamos anotaciones para el setup.
   *
   * En su lugar, sobreescribimos `beforeEach` para partir cada test con una
   * calculadora nueva.
   */
  override def beforeEach(context: BeforeEach): Unit =
    calculator = Some(new Calculator())

  /**
   * Slide 24: `test("...")` define un caso de prueba.
   *
   * El nombre del test describe el comportamiento esperado.
   */
  test("Test addition of two numbers"):
    assertEquals(5, calculator.get.add(2, 3), "2 + 3")
