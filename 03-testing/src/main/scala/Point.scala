package cl.uchile.dcc

/**
 * Ejercicio guiado de la slide 51.
 *
 * Esta clase permite practicar tests sobre un objeto pequeño usando `toString`
 * y `equals` como apoyo para entender mejor los resultados.
 */
class Point(val x: Int, val y: Int):
  /** Devuelve un nuevo punto desplazado por `dx` y `dy`. */
  def moveBy(dx: Int, dy: Int): Point =
    new Point(x + dx, y + dy)

  override def toString: String =
    s"Point($x, $y)"

  override def equals(obj: Any): Boolean =
    if obj.isInstanceOf[Point] then
      val other = obj.asInstanceOf[Point]
      x == other.x && y == other.y
    else false
