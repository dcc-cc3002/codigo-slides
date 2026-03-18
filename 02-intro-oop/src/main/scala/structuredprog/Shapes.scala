package cl.uchile.dcc
package structuredprog

/**
 * Ejemplo de programación estructurada para mostrar figuras geométricas en
 * pantalla.
 *
 * Este módulo implementa un sistema para mostrar diferentes tipos de
 * figuras (cuadrados, círculos, triángulos, rectángulos y polígonos)
 * usando una representación basada en diccionarios (Map).
 *
 * REFERENCIA DE SLIDES: Este código ilustra el problema identifcado en la
 * slide 12: "Seleccionar el comportamiento según el tipo". La función
 * displayShape es un ejemplo de programación estructurada que adolece de
 * dos problemas principales:
 *
 *   1. COHESIÓN DÉBIL (slide 13):
 *      - displayShape concentra más de una responsabilidad: seleccionar el
 *        tipo de figura, extraer sus atributos y coordinar el dibujo.
 *      - La función mezcla lógica de selección, conocimiento de tipos y
 *        dibujo.
 *
 * 2. ALTO ACOPLAMIENTO (slide 13):
 *   - displayShape depende fuertemente de cómo se representan las figuras
 *     (como diccionarios con claves específicas).
 *   - Agregar o modificar tipos de figuras obliga a modificar
 *     displayShape.
 *
 * PELIGROS OCULTOS (slide 14-15):
 *   - Propagación inesperada: cambios en la representación afectan la
 *     lógica de selección.
 *   - Alta fragilidad: es fácil romper el código al agregar nuevos tipos.
 *   - Mayor costo de mantenimiento: la función crece con cada nuevo tipo
 *     de figura.
 */

/**
 * Selecciona qué función de dibujo usar según el tipo de figura.
 *
 * Esta función es un ejemplo de "dispatcher" que centraliza todas las
 * decisiones sobre cómo dibujar figuras. Como se identifica en las slides,
 * este enfoque tiene problemas de cohesión y acoplamiento.
 *
 * @param s
 *   Diccionario con la descripción de la figura. Debe contener la clave
 *   "type" con un valor que sea uno de: "square", "circle", "triangle",
 *   "rectangle", "polygon".
 */
def displayShape(s: Map[String, String]): Unit =
  if s("type") == "square" then drawSquare(s)
  else if s("type") == "circle" then drawCircle(s)
  else if s("type") == "triangle" then drawTriangle(s)
  else if s("type") == "rectangle" then drawRectangle(s)
  else if s("type") == "polygon" then drawPolygon(s)
  else println("Unknown shape type")

/**
 * Dibuja un cuadrado dado su descripción en un diccionario.
 *
 * Como se nota en las slides (slide 11-12): "¿Qué pasa cuando debemos
 * soportar un nuevo tipo de figura?" - agregar nuevas figuras requiere:
 *   1. Crear una nueva función específica 2. Modificar displayShape para
 *      añadir otra rama if/else Esto es lo que las slides llaman un
 *      "problema de escalabilidad".
 *
 * @param s
 *   Diccionario que debe contener "side" (lado del cuadrado) y "position"
 *   (ubicación donde dibujarlo).
 */
def drawSquare(s: Map[String, String]): Unit =
  val side = s("side").toInt
  val position = s("position")
  println(s"Drawing a square of side $side at position $position")

/**
 * Dibuja un círculo dado su descripción en un diccionario.
 *
 * @param s
 *   Diccionario que debe contener "radius" (radio del círculo) y
 *   "position" (ubicación donde dibujarlo).
 */
def drawCircle(s: Map[String, String]): Unit =
  val radius = s("radius").toInt
  val position = s("position")
  println(s"Drawing a circle of radius $radius at position $position")

/**
 * Dibuja un triángulo dado su descripción en un diccionario.
 *
 * @param s
 *   Diccionario que debe contener "base", "height" y "position".
 */
def drawTriangle(s: Map[String, String]): Unit =
  val base = s("base").toInt
  val height = s("height").toInt
  val position = s("position")
  println(
      s"Drawing a triangle with base $base and height $height at position $position"
  )

/**
 * Dibuja un rectángulo dado su descripción en un diccionario.
 *
 * @param s
 *   Diccionario que debe contener "width", "height" y "position".
 */
def drawRectangle(s: Map[String, String]): Unit =
  val width = s("width").toInt
  val height = s("height").toInt
  val position = s("position")
  println(
      s"Drawing a rectangle with width $width and height $height at position $position"
  )

/**
 * Dibuja un polígono dado su descripción en un diccionario.
 *
 * @param s
 *   Diccionario que debe contener "sides" (número de lados) y "position".
 */
def drawPolygon(s: Map[String, String]): Unit =
  val sides = s("sides").toInt
  val position = s("position")
  println(s"Drawing a polygon with $sides sides at position $position")
