package cl.uchile.dcc
package fp.collections

import scala.util.chaining.scalaUtilChainingOps

trait CollectOps[A]:
  def collect[B](f: PartialFunction[A, B]): Iterable[B]

sealed trait Event
case class UserCreated(id: Int, name: String) extends Event
case class UserDeleted(id: Int) extends Event
case object SystemShutDown extends Event

@main def collectExample(): Unit =
  val logUserAction: PartialFunction[Event, String] =
    case UserCreated(id, name) => s"User $id created: $name"
    case UserDeleted(id) => s"User $id deleted"
    // No se incluye el caso SystemShutDown ==> Parcial

  List(UserCreated(1, "Leon"), UserDeleted(2), SystemShutDown)
    .collect(logUserAction)
    // [User 1 created: Leon, User 2 deleted]
    .tap(println)
  () // Para satisfacer al compilador