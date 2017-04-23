package eu.stolin.dw3

fun main(args: Array<String>) {
    println("Enter complete binary tree:")
    val input = readLine()!!.split(" ").map { it.toInt() }
    //validate input here

    val tree = Tree(input)

    println("Enter tree traversal:")
    val alg: Algorithm = Algorithm.valueOf(readLine()!!)

    println("Enter action:")
    val opInput: String = readLine()!!
    val op: Operation = when(opInput) {
        Operation.Print().stringValue -> Operation.Print()
        Operation.PlusMinus().stringValue -> Operation.PlusMinus()
        else -> throw IllegalArgumentException(opInput)
    }

    tree.traverse(alg, op)
    println(op.result())

}

