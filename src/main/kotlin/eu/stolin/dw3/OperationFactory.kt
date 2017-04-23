package eu.stolin.dw3


object OperationFactory {

    fun fromString(name: String): Operation {
        val op: Operation = when(name) {
            Operation.Print().stringValue -> Operation.Print()
            Operation.PlusMinus().stringValue -> Operation.PlusMinus()
            else -> throw IllegalArgumentException("unknown input $name")
        }
        return op
    }
}