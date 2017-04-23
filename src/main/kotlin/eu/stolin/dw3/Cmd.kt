package eu.stolin.dw3

fun main(args: Array<String>) {
    println("Enter complete binary tree:")
    val input = readLine()!!.split(" ").map { it.toInt() }
    //validate input here

    val tree = Tree(input)

    println("Enter tree traversal:")
    val alg: Algorithm = AlgorithmFactory.fromString(readLine()!!)

    println("Enter action:")
    val opInput: String = readLine()!!

    val op: Operation = OperationFactory.fromString(opInput)
    alg.traverse(tree.treeRoot!!, op)

    println(op.result())
}

