package cl.uchile.dcc
package fp.basics

/** Implementación con estado mutable usando `var`. */
object MutableImplementation:
  class Asteroid(var name: String, var diameter: Double)

  var a = new Asteroid("Ceres", 939.4)
  a.diameter = 940.0 // El valor cambia directamente

/** Implementación inmutable que crea nuevas instancias en cada cambio. */
object ImmutableImplementation:
  case class Asteroid(name: String, diameter: Double)

  val a = Asteroid("Ceres", 939.4)
  val modifiedA: Asteroid = a.copy(diameter = 940.0) // crea una nueva instancia
