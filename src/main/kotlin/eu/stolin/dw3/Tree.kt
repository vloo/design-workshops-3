package eu.stolin.dw3


object Tree {


    fun constructTree(values: List<Int>): Node {
        return constructTree(values, 0)
    }


    private fun constructTree(input: List<Int>, index: Int): Node {
        if (input.size > index) {
            val value = input[index]
            val node = Node.ValueNode(value, constructTree(input, index * 2 + 1), constructTree(input, index * 2 + 2))
            return node
        }
        return Node.EmptyNode()
    }


}