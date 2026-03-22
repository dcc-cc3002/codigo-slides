package cl.uchile.dcc
package tree

// Caso base del arbol: no depende de Option ni de nodos ausentes.
class Leaf(val value: Int) extends Tree:
  override def sum: Int = value
  override def min: Int = value
  override def max: Int = value
