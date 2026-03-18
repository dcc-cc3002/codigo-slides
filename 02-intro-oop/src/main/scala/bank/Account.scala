package cl.uchile.dcc
package bank

/**
 * Interfaz modular que define las responsabilidades de una cuenta
 * bancaria.
 *
 * Esta interfaz (trait) especifica "qué" mensajes puede recibir una
 * cuenta, sin definir "cómo" los responde. Los métodos públicos definen la
 * interfaz del objeto, es decir, los servicios que expone a otros objetos.
 *
 * Nota: Normalmente, el estado (campos) no es visible desde fuera del
 * objeto, solo lo es a través de estos métodos públicos.
 *
 * Ver slides: "Interfaces modulares en Scala" y "Nivel de implementación"
 */
trait Account:
  def getBalance: Int
  def withdraw(amount: Int): Boolean
  def deposit(amount: Int): Boolean

/**
 * Implementación concreta de la interfaz Account para Bigby Wolf.
 *
 * Podemos crear objetos con la palabra clave "object". Esta implementación
 * requiere proporcionar un cuerpo para todos los métodos definidos en el
 * trait.
 *
 * Estructura del nivel de implementación:
 *   - Comportamiento: métodos públicos que definen la interfaz
 *     (getBalance, withdraw, deposit)
 *   - Estado: campos (balance, currency) que pueden ser mutables (var) o
 *     inmutables (val). Normalmente, no son visibles desde fuera del
 *     objeto.
 *
 * Ver slides: "Nivel de implementación" y "Crear objetos en Scala"
 */
object AccountOfBigby extends Account:
  // Estado: Campos
  var balance: Int = 50_000
  val currency: String = "CLP"

  // Comportamiento: Métodos
  override def getBalance: Int = balance

  override def withdraw(amount: Int): Boolean =
    if balance >= amount then
      balance -= amount
      true
    else false

  override def deposit(amount: Int): Boolean =
    balance += amount
    true

/**
 * Ejemplo que demuestra la buena práctica de programar contra interfaces.
 *
 * Nota que la variable "account" tiene tipo "Account" (la interfaz), no
 * "AccountOfBigby" (la implementación concreta). Esto permite que el
 * código sea flexible: podríamos cambiar la implementación sin modificar
 * este método.
 *
 * ¡Ambos son correctos! `AccountOfBigby` es un Account, pero cuando
 * programamos contra interfaces, usamos el tipo más general (Account).
 *
 * Ver slides: "Pregunta" - "¿account es de tipo `AccountOfBigby` o
 * Account?"
 */
@main def testAccount(): Unit =
  val account: Account = AccountOfBigby
  println(account.getBalance)
