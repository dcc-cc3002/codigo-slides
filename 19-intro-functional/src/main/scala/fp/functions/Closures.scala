//noinspection ScalaWeakerAccess
package cl.uchile.dcc
package fp.functions

/** Ejemplo de clausuras: la función devuelta captura `base`. */
object Closures:
  def makeAdder(base: Double): Double => Double =
    temp => temp + base // la lambda recuerda 'base'

  val toKelvin: Double => Double =
    makeAdder(273.15) // fija un desplazamiento constante desde Celsius

  @main def run(): Unit =
    println(toKelvin(25)) // 298.15
