package eu.stolin.dw3


object OperationFactory {

    fun fromString(name: String): Operation {
        return when(name) {
            "print" -> Operation.Print()
            "+-" -> Operation.PlusMinus()
            else -> throw IllegalArgumentException("unknown input $name")
        }
    }
}