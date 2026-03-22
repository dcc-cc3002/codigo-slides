package cl.uchile.dcc
package animals

// Un trait funciona como contrato: cualquier clase que lo implemente
// promete proveer estos miembros.
trait Legged:
  val numLegs: Int

  def walk(): Unit
