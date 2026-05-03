package cl.uchile.dcc
package recursion

import scala.util.control.NoStackTrace

class Node(val value: Int,
           val left: Option[Node] = None,
           val right: Option[Node] = None)

object SearchWithoutThrowable:
  def contains(root: Option[Node], target: Int): Boolean =
    var found = false

    def visit(node: Option[Node]): Unit =
      if node.isDefined then
        if node.get.value == target then
          found = true

        visit(node.get.left)
        visit(node.get.right)

    visit(root)
    found

object Found extends Throwable with NoStackTrace

object SearchWithThrowable:
  def contains(root: Option[Node], target: Int): Boolean =
    def visit(node: Option[Node]): Unit =
      if node.isDefined then
        if node.get.value == target then
          throw Found

        visit(node.get.left)
        visit(node.get.right)

    try
      visit(root)
      false
    catch
      case Found => true
