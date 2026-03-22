package cl.uchile.dcc
package tree

// Una sola abstraccion con multiples implementaciones concretas.
trait Tree:
  def sum: Int
  def min: Int
  def max: Int

@main def treeExample(): Unit =
  val tree: Tree =
    new InternalNode(
      34,
      new InternalNode(
        13,
        new Leaf(4),
        new Leaf(25)
      ),
      new Leaf(45)
    )

  println(s"sum = ${tree.sum}")
  println(s"min = ${tree.min}")
  println(s"max = ${tree.max}")
