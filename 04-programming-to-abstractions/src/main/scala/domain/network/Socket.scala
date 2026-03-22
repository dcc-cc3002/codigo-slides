package cl.uchile.dcc
package domain.network

import scala.collection.immutable.ListMap

// Este ejemplo contrasta con Student.scala:
// cuando solo queremos valores por defecto, no necesitamos
// varios constructores auxiliares para cubrir combinaciones simples.
class Socket(val timeout: Int = 5000, val linger: Int = 5000):
  def describe(): String =
    s"timeout = $timeout, linger = $linger"

@main def socketExample(): Unit =
  // Los argumentos con nombre y los valores por defecto permiten
  // expresar este caso de forma más directa que con constructores auxiliares.
  val sockets = ListMap(
      "s1 = Socket()" -> new Socket(),
      "s2 = Socket(1000)" -> new Socket(1000),
      "s3 = Socket(1000, 2000)" -> new Socket(1000, 2000),
      "s4 = Socket(linger = 3000)" -> new Socket(linger = 3000),
      "s5 = Socket(timeout = 1000, linger = 3000)" -> new Socket(
        timeout = 1000,
        linger = 3000
      ),
      "s6 = Socket(linger = 3000, timeout = 1000)" -> new Socket(
        linger = 3000,
        timeout = 1000
      )
  )

  for (label, socket) <- sockets do
    println(s"$label -> ${socket.describe()}")
