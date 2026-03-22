package cl.uchile.dcc
package polymorphism

class Duck:
  def m1(): Unit = println("Duck.m1")
  def m2(): Int = 7
  def m3(): String = "quack"

class Witch:
  def m1(): Unit = println("Witch.m1")
  def m2(): Int = 13
  def m3(): String = "spell"

// Scala exige una relacion explicita de subtipo.
// Aunque Witch tenga los mismos miembros, no puede usarse donde
// se espera un Duck.
def foo(d: Duck): String =
  d.m1()
  s"${d.m2()} - ${d.m3()}"

@main def subtypePolymorphismExample(): Unit =
  val duck = new Duck()
  val witch = new Witch()

  println(s"foo(duck) = ${foo(duck)}")
  println(s"Witch also has similar methods: ${witch.m2()} - ${witch.m3()}")
  // foo(witch) // No compila: Witch no es subtipo de Duck.
