package cl.uchile.dcc
package polymorphism.parametric.fbound

/**
 * Slides 35-36: contrato genérico para comparar valores del mismo tipo.
 *
 * `ComparableTo[Person]` obliga a que una persona se compare con otra
 * persona, no con un objeto arbitrario.
 */
trait ComparableTo[T]:
  def compareTo(other: T): Int

class Person(
    val name: String,
    val age: Int
) extends ComparableTo[Person]:
  override def compareTo(other: Person): Int =
    this.age - other.age

trait Sorter[T <: ComparableTo[T]]:
  def sort(values: List[T]): List[T]

/**
 * Slide 36: implementación concreta de `Sorter`.
 *
 * El algoritmo es deliberadamente simple: compara pares adyacentes e
 * intercambia si están fuera de orden. La idea principal es la cota `T <:
 * ComparableTo[T]`, no la eficiencia del ordenamiento.
 */
class BubbleSorter[T <: ComparableTo[T]] extends Sorter[T]:
  override def sort(values: List[T]): List[T] =
    var result = values
    var i = 0
    while i < result.length do
      var j = 0
      while j < result.length - i - 1 do
        if result(j).compareTo(result(j + 1)) > 0 then
          val temp = result(j)
          result = result.updated(j, result(j + 1))
          result = result.updated(j + 1, temp)
        j = j + 1
      i = i + 1
    result

@main def sorterExample(): Unit =
  val people = List(
      new Person("Ichigo Kurosaki", 17),
      new Person("Rukia Kuchiki", 22),
      new Person("Renji Abarai", 26),
      new Person("Byakuya Kuchiki", 32),
      new Person("Orihime Inoue", 16),
      new Person("Uryu Ishida", 17)
  )

  val sorter = new BubbleSorter[Person]
  val sorted = sorter.sort(people)

  println("Original:")
  people.foreach(p => println(s"  ${p.name} - ${p.age}"))

  println("Sorted:")
  sorted.foreach(p => println(s"  ${p.name} - ${p.age}"))
