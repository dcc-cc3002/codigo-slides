package cl.uchile.dcc
package money

import scala.collection.mutable

/**
 * Agrupa montos de distintas divisas usando un diccionario mutable.
 *
 * La slide 42 introduce esta estructura y la slide 48 muestra cómo `Option`
 * evita depender de referencias nulas al consultar el mapa.
 */
class MoneyBag:
  val monies: mutable.Map[String, Money] =
    mutable.Map.empty

  def this(bag: Set[Money]) =
    this()
    for m <- bag do appendMoney(m)
  def this(m1: Money, m2: Money) =
    this(Set(m1, m2))

  def appendMoney(money: Money): Unit =
    val oMoney: Option[Money] = monies.get(money.currency)
    val newMoney: Money =
      if oMoney.isEmpty then money
      else oMoney.get.add(money)
    monies.update(money.currency, newMoney)

  override def toString: String =
    monies.values.mkString(", ")

  override def equals(obj: Any): Boolean =
    if obj.isInstanceOf[MoneyBag] then
      val other = obj.asInstanceOf[MoneyBag]
      monies == other.monies
    else false
