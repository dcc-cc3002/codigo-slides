package cl.uchile.dcc
package money

import java.util.Objects
import scala.collection.mutable

/**
 * Agrupa montos de distintas divisas usando un diccionario mutable.
 *
 * La slide 42 introduce esta estructura y la slide 48 muestra cómo
 * `Option` evita depender de referencias nulas al consultar el mapa.
 */
class MoneyBag(bag: Set[Money]):
  val monies: mutable.Map[String, Money] =
    mutable.Map.empty
  for m <- bag do appendMoney(m)

  def this(m1: Money, m2: Money) =
    this(Set(m1, m2))

  override def toString: String =
    monies.values.mkString(", ")

  def appendMoney(money: Money): Unit =
    val oMoney: Option[Money] = monies.get(money.currency)
    val newMoney: Money =
      if oMoney.isEmpty then money
      else oMoney.get.add(money)
    monies.update(money.currency, newMoney)

  // noinspection TypeCheckCanBeMatch
  override def equals(obj: Any): Boolean =
    if obj.isInstanceOf[MoneyBag] then
      val other = obj.asInstanceOf[MoneyBag]
      monies == other.monies
    else false

  override def hashCode(): Int =
    Objects.hash(classOf[MoneyBag], monies)
