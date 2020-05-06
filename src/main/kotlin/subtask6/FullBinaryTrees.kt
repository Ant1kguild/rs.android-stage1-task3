package subtask6

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        val result = ArrayList<ArrayList<Int?>>()

        for (node in count.allBinaryTrees()) {
            val list = node.convertToList()
            while (list[list.size - 1] == null) list.removeAt(list.size - 1)
            result.add(list)
        }
        return result.toString()
    }




    inner class Node(var depth: Int = 0, var left: Node? = null, var right: Node? = null)

    private fun Node.convertToList(): ArrayList<Int?> {
        var currentLevel = 0
        val result = ArrayList<Int?>()
        result.add(0)
        val child = ArrayList<Node?>()
        child.add(this.left)
        child.add(this.right)
        while (child.isNotEmpty()) {
            val newChildren = ArrayList<Node?>()
            for (node in child) {
                if (node == null) {
                    if (currentLevel != this.depth) result.add(null)
                } else {
                    result.add(0)
                    newChildren.add(node.left)
                    newChildren.add(node.right)
                }
            }
            currentLevel++
            child.clear()
            child.addAll(newChildren)
            newChildren.clear()
        }
        return result
    }

    private fun Int.allBinaryTrees(): ArrayList<Node> {
        if (this == 1) return arrayListOf(Node())
        if (this % 2 == 0) return ArrayList()
        val result = ArrayList<Node>()
        for (i in 1 until this step 2) {
            val left = i.allBinaryTrees()
            val right = (this -(i+1)).allBinaryTrees()
            for (leftNode in left) {
                for (rightNode in right)
                    result.add(
                        Node(
                            maxOf(leftNode.depth, rightNode.depth) + 1,
                            leftNode,
                            rightNode
                        )
                    )
            }
        }
        return result
    }
}
