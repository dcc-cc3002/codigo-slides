package cl.uchile.dcc
package animals

import java.awt.Color

// Una clase puede mezclar multiples traits y debe cumplir
// las promesas de todos ellos.
class AkitaInu(val name: String) extends Legged, Tailed:
  override val numLegs: Int = 4 // Contrato de Legged

  override def walk(): Unit = // Contrato de Legged
    println(s"$name is walking on $numLegs legs.")

  override val tailColor: Color = // Contrato de Tailed
    Color.WHITE

@main def akitaInuExample(): Unit =
  val d = new AkitaInu("Daisuke")
  d.walk()
  println(s"${d.name}'s tail color is ${d.tailColor}.")
