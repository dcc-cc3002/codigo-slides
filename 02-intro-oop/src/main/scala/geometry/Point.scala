package cl.uchile.dcc
package geometry

class Point(val x: Int, val y: Int):
  def move(deltaX: Int, deltaY: Int): Point =
    new Point(x + deltaX, y + deltaY)
