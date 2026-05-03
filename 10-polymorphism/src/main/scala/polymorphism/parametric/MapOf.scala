package cl.uchile.dcc
package polymorphism.parametric

/**
 * Slide 23: ejemplo minimo con dos parámetros de tipo.
 *
 * `K` es el tipo de las llaves y `V` es el tipo de los valores. En una
 * implementación completa habría una estructura interna; aquí basta con el
 * contrato para mostrar que ambos tipos se mantienen relacionados.
 */
trait MapOf[K, V]:
  def get(key: K): Option[V]

  def put(key: K, value: V): MapOf[K, V]

/**
 * Implementación simple con fines ilustrativos.
 *
 * Usa una lista simple de pares (clave, valor) para guardar los datos. Las
 * operaciones buscan linealmente (no es eficiente, pero es clara).
 */
class SimpleMapOf[K, V](private val pairs: List[(K, V)] = List())
    extends MapOf[K, V]:

  override def get(key: K): Option[V] =
    // Busca la primera clave que coincida con la dada
    var result: Option[V] = scala.None
    var index = 0
    while index < pairs.length do
      val pair = pairs(index)
      if pair._1 == key then result = scala.Some(pair._2)
      index = index + 1
    result

  override def put(key: K, value: V): MapOf[K, V] =
    // Si la clave ya existe, la reemplaza; si no, la agrega
    var updated: List[(K, V)] = List()
    var index = 0
    while index < pairs.length do
      val pair = pairs(index)
      if pair._1 != key then updated = updated :+ pair
      index = index + 1
    updated = updated :+ (key, value)
    new SimpleMapOf(updated)

@main def mapOfExample(): Unit =
  var map: MapOf[String, Int] = new SimpleMapOf()

  map = map.put("edad", 25)
  map = map.put("id", 1001)

  val edad = map.get("edad")
  val id = map.get("id")
  val noExiste = map.get("noExiste")

  println(s"edad: $edad")
  println(s"id: $id")
  println(s"noExiste: $noExiste")
