package cl.uchile.dcc
package bank

class SimpleAccount(
    var balance: Int,
    var currency: String
) extends Account:
  def getBalance: Int = balance
  def withdraw(amount: Int): Boolean =
    if balance >= amount then
      balance -= amount
      true
    else false
  def deposit(amount: Int): Boolean =
    balance += amount
    true

@main def testSimpleAccount(): Unit =
  val account: Account = new SimpleAccount(50_000, "CLP")
  println(account.getBalance)
