package eu.stolin.dw3


sealed class Operation {

    abstract val stringValue: String

    abstract fun apply(node: Node)

    abstract fun result(): String

    class PlusMinus : Operation() {
        var result = 0
        var isPlus = true
        override val stringValue = "+-"

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

    class Print : Operation() {
        var list = emptyList<Int>()

        override val stringValue = "print"
        override fun apply(node: Node) {
            list += node.value
        }

        override fun result(): String {
            return list.fold("") { total, next -> total + " " + next }
        }
    }
}