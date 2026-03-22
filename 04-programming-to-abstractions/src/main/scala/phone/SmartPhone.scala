package cl.uchile.dcc
package phone

// Camera y Phone son contratos independientes.
trait Camera:
  def takePhoto(): Unit

trait Phone:
  def makeCall(number: String): Unit

// Un trait tambien puede extender otros traits y apilar capacidades.
trait Smartphone extends Camera, Phone

class BasicSmartphone extends Smartphone:
  override def takePhoto(): Unit =
    println("Taking a photo.")

  override def makeCall(number: String): Unit =
    println(s"Calling $number.")

@main def smartphoneExample(): Unit =
  val phone: Smartphone = new BasicSmartphone()
  phone.takePhoto()
  phone.makeCall("+56 2 5555 5555")
