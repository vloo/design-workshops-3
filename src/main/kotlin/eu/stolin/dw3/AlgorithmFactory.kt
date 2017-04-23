package eu.stolin.dw3


object AlgorithmFactory {

    fun fromString(name: String): Algorithm {
        return when(name) {
            "depth" -> Algorithm.DepthAlgorithm()
            "breadth" -> Algorithm.BreadthAlgorithm()
            else -> throw IllegalArgumentException("unknown input $name")
        }
    }
}