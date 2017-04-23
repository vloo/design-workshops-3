package eu.stolin.dw3


sealed class Node {

    class ValueNode(val value: Int, val left: Node, val right: Node): Node()

    class EmptyNode : Node()
}