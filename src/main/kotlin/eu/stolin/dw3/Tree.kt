package eu.stolin.dw3


object Tree {


    fun constructTree(values: List<Int>): Node? {
        return constructTree(values, 0)
    }


    private fun constructTree(input: List<Int>, index: Int): Node? {
        if (input.size > index) {
            val value = input[index]
            val node = Node(value)
            node.left = constructTree(input, index * 2 + 1)
            node.right = constructTree(input, index * 2 + 2)
            return node
        }
        return null
    }


}