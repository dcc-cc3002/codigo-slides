package cl.uchile.dcc
package domain.people

// El cuerpo de la clase tambien participa de la inicializacion.
class Person(val firstName: String, val lastName: String):
  println("Initialization begins.")

  val fullName = s"$firstName $lastName"

  def printFullName(): Unit = println(fullName)

  println("Initialization ends.")

@main def personExample(): Unit =
  val p = new Person("Tom", "Hagen")
  p.printFullName()
