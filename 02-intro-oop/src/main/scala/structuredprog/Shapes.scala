package cl.uchile.dcc
package structuredprog

def displayShape(s: Map[String, String]): Unit =
  if s("type") == "square" then drawSquare(s)
  else if s("type") == "circle" then drawCircle(s)
  else if s("type") == "triangle" then drawTriangle(s)
  else if s("type") == "rectangle" then drawRectangle(s)
  else if s("type") == "polygon" then drawPolygon(s)
  else println("Unknown shape type")

def drawSquare(s: Map[String, String]): Unit =
  val side = s("side").toInt
  val position = s("position")
  println(s"Drawing a square of side $side at position $position")

def drawCircle(s: Map[String, String]): Unit =
  val radius = s("radius").toInt
  val position = s("position")
  println(s"Drawing a circle of radius $radius at position $position")

def drawTriangle(s: Map[String, String]): Unit =
  val base = s("base").toInt
  val height = s("height").toInt
  val position = s("position")
  println(s"Drawing a triangle with base $base and height $height at position $position")

def drawRectangle(s: Map[String, String]): Unit =
  val width = s("width").toInt
  val height = s("height").toInt
  val position = s("position")
  println(s"Drawing a rectangle with width $width and height $height at position $position")

def drawPolygon(s: Map[String, String]): Unit =
  val sides = s("sides").toInt
  val position = s("position")
  println(s"Drawing a polygon with $sides sides at position $position")
