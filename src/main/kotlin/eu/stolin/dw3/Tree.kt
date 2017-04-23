package eu.stolin.dw3

import java.util.*


class Tree {

    var treeRoot: Node? = null

    constructor(values: List<Int>) {
        treeRoot = constructTree(values, 0)
    }

    fun traverse(alg: Algorithm, op: Operation) {
        when(alg) {
            Algorithm.breadth -> breadth(op)
            Algorithm.depth -> depth(op)
        }
    }

    fun constructTree(input: List<Int>, index: Int): Node? {
        if (input.size > index) {
            val value = input[index]
            val node = Node(value)
            node.left = constructTree(input, index * 2 + 1)
            node.right = constructTree(input, index * 2 + 2)
            return node
        }
        return null
    }

    fun breadth(op: Operation) {
        val queue = LinkedList<Node?>()
        queue.add(treeRoot)

        while (!queue.isEmpty()) {
            val node = queue.remove()

            //operation
            op.apply(node!!)
            if (node.left != null) queue.add(node.left)
            if (node.right != null) queue.add(node.right)
        }

    }

    fun depth(op: Operation) {
        depthTraverse(treeRoot!!, op)

    }

    fun depthTraverse(node: Node, op: Operation) {

        op.apply(node)
        if(node.left != null) {
            depthTraverse(node.left!!, op)
        }
        if (node.right != null) {
            depthTraverse(node.right!!, op)
        }
    }





}