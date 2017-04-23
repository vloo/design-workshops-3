package eu.stolin.dw3

import java.util.*


sealed class Algorithm {

    abstract fun traverse(node: Node, op: Operation)

    class DepthAlgorithm: Algorithm() {

        override fun traverse(node: Node, op: Operation) {
            op.apply(node)
            if(node.left != null) {
                traverse(node.left!!, op)
            }
            if (node.right != null) {
                traverse(node.right!!, op)
            }
        }
    }

    class BreadthAlgorithm: Algorithm() {

        override fun traverse(node: Node, op: Operation) {
            val queue = LinkedList<Node?>()
            queue.add(node)

            while (!queue.isEmpty()) {
                val node = queue.remove()

                //operation
                op.apply(node!!)
                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
            }
        }
    }
}