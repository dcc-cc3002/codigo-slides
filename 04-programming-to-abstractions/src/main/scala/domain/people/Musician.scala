package cl.uchile.dcc
package domain.people

// Una clase define el tipo del objeto y la informacion minima
// que necesitamos para dejarlo listo al construirlo.
class Musician(var name: String, var role: String)

@main def musicianExample(): Unit =
  val m = new Musician("Masashi Hamauzu", "Composer")
  println(s"${m.name} is a ${m.role}")
  m.name = "Chris Shiflett"
  println(s"Now the musician is ${m.name}.")
