package cl.uchile.dcc
package animals

class Dog(val name: String) extends Animal:
  def talk(): Unit =
    println(s"$name: Woof!")

@main def dogMain(): Unit =
  val dog1: Animal = new Dog("Alexander")
  dog1.talk()
  val dog2: Animal = new Dog("Bond")
  dog2.talk()
