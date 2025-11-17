package cl.uchile.dcc
package fp.functions

/** Ejemplo de currificación: función aplicada en varios pasos. */
object Currying:
  case class User(name: String, email: String, age: Int)

  def createUser(name: String)(email: String)(age: Int): User =
    // Podemos fijar parámetros de a uno: createUser("Alice")("a@mail.com")(20)
    User(name, email, age)

  @main def curryingExample(): Unit =
    // Ejemplo paso a paso de currificación: fijamos argumentos uno a uno.
    // Cada valor tiene el tipo correspondiente a la siguiente función pendiente.
    val step1ProvideName: String => (String => (Int => User)) = createUser
    val step2ProvideEmail: String => (Int => User) = step1ProvideName("Cloud")
    val step3ProvideAge: Int => User = step2ProvideEmail("counter.strife@example.com")
    val finalUser: User = step3ProvideAge(21)

    // Mostramos el usuario final para verificar el flujo.
    println(finalUser)
