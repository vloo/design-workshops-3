package eu.stolin.dw3


sealed class Operation {

    abstract fun apply(node: Node)

    abstract fun result(): String

    class PlusMinus : Operation() {
        var result = 0
        var isPlus = true

        override fun apply(node: Node) {
            if (isPlus) {
                result += node.value
            } else {
                result -= node.value
            }
            isPlus = !isPlus
        }

        override fun result(): String {
            return result.toString()
        }
    }

    abstract class CollectingOperation: Operation() {
        var list = emptyList<Int>()

        override fun apply(node: Node) {
            list += node.value
        }
    }

    class Print : CollectingOperation() {
        override fun result(): String {
            return list.fold("") { total, next -> total + " " + next }
        }
    }

    class PrintReverse: CollectingOperation() {
        override fun result(): String {
            return list.reversed().fold("") { total, next -> total + " " + next }
        }
    }
}