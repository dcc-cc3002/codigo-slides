package cl.uchile.dcc
package geometry

class Rectangle(val origin: Point, val height: Int, val width: Int)
    extends IRectangle:
  def move(x: Int, y: Int): IRectangle =
    new Rectangle(origin.move(x, y), height, width)

  def area(): Int = height * width
