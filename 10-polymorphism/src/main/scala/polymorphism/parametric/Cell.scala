package cl.uchile.dcc
package polymorphism.parametric

/**
 * Slides 11-15: una celda con `Any` es flexible, pero pierde información.
 *
 * El getter devuelve `Any`, por lo que el compilador ya no puede
 * garantizar que el valor siga siendo del tipo que esperamos.
 */
class UnsafeCell(private var _element: Any):
  def element: Any =
    _element

  def element_=(element: Any): Unit =
    _element = element

/**
 * Slides 16-18: el parametro de tipo mantiene la información.
 *
 * Al crear `Cell[String]`, el compilador exige que todos los valores
 * escritos y leidos sean compatibles con `String`.
 */
class Cell[T](private var _element: T):
  def element: T =
    _element

  def element_=(element: T): Unit =
    _element = element

object CellExamples:
  def overwriteUnsafeCell(cell: UnsafeCell): Unit =
    cell.element = 2

  def overwriteStringCell(cell: Cell[String]): Unit =
    // Slide 18: descomenta esta línea para ver el error de compilación.
    // Cell.element = 2
    cell.element = "Goodbye"

@main def unsafeCellExample(): Unit =
  val cell = new UnsafeCell("Hello")
  CellExamples.overwriteUnsafeCell(cell)

  // Slide 14: este cast compila, pero falla en ejecución si el valor real no
  // es String. Por eso queda dentro de un try/catch para poder ejecutar la demo.
  try
    val text: String = cell.element.asInstanceOf[String]
    println(text.toUpperCase)
  catch
    case error: ClassCastException =>
      // Capturamos solo para ilustrar el error. Usualmente, no debiéramos capturar ClassCastException.
      println(error.getClass.getSimpleName)

@main def genericCellExample(): Unit =
  val cell = new Cell[String]("Hello")
  CellExamples.overwriteStringCell(cell)

  val text: String = cell.element
  println(text.toUpperCase)
