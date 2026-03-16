package cl.uchile.dcc
package animals

/**
 * Clase Dog: ejemplo de fábrica de objetos que extiende Animal.
 *
 * REFERENCIA DE SLIDES (Slide 43): Una clase es una "fábrica" de objetos.
 * Describe qué valores necesitas para crear un objeto, su estado y
 * comportamiento. En este caso:
 *   - Estado: el nombre del perro (name: String)
 *   - Comportamiento: qué hace el perro cuando "habla" (método talk)
 *
 * HERENCIA: Dog implementa Animal, lo que significa que hereda su contrato
 * (trait) y debe implementar sus métodos abstractos.
 */
class Dog(val name: String) extends Animal:
  /**
   * Implementa el comportamiento de habla del perro.
   *
   * Este método es específico de la clase Dog. Cada instancia de Dog puede
   * tener un nombre diferente, pero todas compartirán esta misma
   * implementación del método talk().
   */
  def talk(): Unit =
    println(s"$name: Woof!")

/**
 * Ejemplo de uso: creación de múltiples instancias de Dog.
 *
 * REFERENCIA DE SLIDES (Slide 45): Este ejemplo muestra cómo dos
 * instancias diferentes (dog1 y dog2) pueden: <ol> <li> Compartir la misma
 * clase y comportamiento (ambos son Dog, ambos tienen talk()) </li> <li>
 * Tener diferente estado (Alexander vs. Bond) </li> <li> Ser tratadas
 * polimórficamente como Animal (el tipo declarado es Animal) </li> </ol>
 *
 * Esto ilustra que la clase es efectivamente una fábrica: cada llamada a
 * `new Dog(...)` produce un nuevo objeto con sus propios valores de state
 * (el nombre) pero la misma lógica de comportamiento (el método talk).
 */
@main def dogMain(): Unit =
  // Instancia 1: Dog con nombre "Alexander"
  val dog1: Animal = new Dog("Alexander")
  dog1.talk()

  // Instancia 2: Dog con nombre "Bond"
  val dog2: Animal = new Dog("Bond")
  dog2.talk()
