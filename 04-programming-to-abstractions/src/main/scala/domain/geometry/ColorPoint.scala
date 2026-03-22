package cl.uchile.dcc
package domain.geometry

import java.awt.Color

// Este ejemplo muestra inicializacion incompleta:
// el punto existe, pero su color puede quedar ausente.
class ColorPoint(var x: Double, var y: Double):
  var color: Option[Color] = None

  def setColor(c: Color): Unit =
    color = Some(c)

@main def colorPointExample(): Unit =
  val point = new ColorPoint(10, 20)
  println(s"Initial color: ${point.color}")
  point.setColor(Color.RED)
  println(s"Updated color: ${point.color}")
