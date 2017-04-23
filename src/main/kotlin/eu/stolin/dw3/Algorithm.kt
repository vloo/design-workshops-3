package eu.stolin.dw3

import java.util.*


sealed class Algorithm {

    abstract fun traverse(node: Node, op: Operation)

    class DepthAlgorithm: Algorithm() {

        override fun traverse(node: Node, op: Operation) {
            if (node is Node.ValueNode) {
                op.apply(node)
                traverse(node.left, op)
                traverse(node.right, op)
            }
        }
    }

    class BreadthAlgorithm: Algorithm() {

        override fun traverse(node: Node, op: Operation) {
            val queue = LinkedList<Node>()
            queue.add(node)

            while (!queue.isEmpty()) {
                val node = queue.remove()
                if (node is Node.ValueNode) {
                    op.apply(node)
                    queue.add(node.left)
                    queue.add(node.right)
                }
            }
        }
    }
}