package cl.uchile.dcc
package polymorphism.subtype

/**
 * Slide 4: `SimpleChild` es subtipo de `SimpleParent`.
 *
 * La idea importante no es que `SimpleChild` "contenga código" de
 * `SimpleParent`, sino que un objeto de tipo `SimpleChild` puede usarse en
 * cualquier lugar donde se espera un `SimpleParent`.
 */
class SimpleParent:
  def name: String =
    "parent"

class SimpleChild extends SimpleParent:
  override def name: String =
    "child"

@main def subtypeContainmentExample(): Unit =
  val value: SimpleParent = new SimpleChild

  // Slide 9: este método se resuelve en ejecución. La variable tiene tipo
  // SimpleParent, pero el objeto real es SimpleChild.
  println(value.name)
