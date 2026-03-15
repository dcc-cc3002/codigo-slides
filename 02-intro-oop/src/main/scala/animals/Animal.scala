package cl.uchile.dcc
package animals

/**
 * Interfaz que define las responsabilidades de un animal.
 *
 * Define los métodos que todo animal debe implementar:
 *   - name: el nombre del animal
 *   - talk(): el sonido o mensaje que emite
 */
trait Animal:
  val name: String
  def talk(): Unit

/**
 * Creación de objetos de forma nominal (Slide 39-40).
 *
 * En Scala podemos crear objetos con la palabra clave "object" y
 * asignarles un nombre (Alexander). Este es un objeto singleton que existe
 * una única vez en la aplicación.
 *
 * Note la interpolación de cadenas: s"$name: Ed...ward"
 *   - s"..." permite usar $variable para variables simples
 *   - ${expr} permite usar expresiones complejas (ej. s"${x.foo}")
 *
 * Ver slides: "Crear objetos en Scala" (Formas nominal, Slide 39-40)
 */
object Alexander extends Animal:
  val name: String = "Alexander"
  def talk(): Unit =
    println(s"$name: Ed...ward")

/**
 * Creación de objetos de forma anónima (Slide 42).
 *
 * También podemos crear objetos anónimos usando "new Interfaz:" sin
 * asignarles un nombre específico. El objeto se crea en el momento en que
 * se ejecuta esta expresión.
 *
 * Esto es útil para crear instancias temporales o individuales de una
 * interfaz.
 *
 * Ver slides: "Crear objetos en Scala" (Formas anónima, Slide 42)
 */
@main def run(): Unit =
  val alexander = new Animal:
    val name: String = "Alexander"
    def talk(): Unit =
      println(s"$name: Ed...ward")
  alexander.talk()
