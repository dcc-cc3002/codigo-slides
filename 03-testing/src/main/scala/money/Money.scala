package cl.uchile.dcc
package money

/**
 * Representa una cantidad en una divisa.
 *
 * Las slides 32, 35 y 37 usan esta clase para mostrar cómo el test empuja el
 * diseño y por qué conviene redefinir `toString` y `equals`.
 */
class Money(val amount: Int, val currency: String):
  /** Slide 32: sumar montos de la misma divisa produce otro `Money`. */
  def add(other: Money): Money =
    new Money(amount + other.amount, currency)

  /** Slide 35: una representación legible ayuda a entender fallos en tests. */
  override def toString: String =
    s"Money($amount, $currency)"

  /** Slide 37: la igualdad debe comparar estado, no direcciones de memoria. */
  override def equals(obj: Any): Boolean =
    if obj.isInstanceOf[Money] then
      val other = obj.asInstanceOf[Money]
      amount == other.amount && currency == other.currency
    else false
