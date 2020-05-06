package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val list = itemsFromArray
            .filterIsInstance<Int>()
            .sortedBy { it.absoluteValue }
            .reversed()

        if (list.isNotEmpty()) {
            if (list.count() <= numberOfItems) return list.multiplication()

            val resultAll = list.multiplicationCount(numberOfItems)
            val resultPositive = list.multiplicationCountPositive(numberOfItems)

            return if (resultPositive >= resultAll) {
                resultPositive
            } else {
                resultAll
            }
        }
        return 0
    }

    private fun List<Int>.multiplication(): Int {
        var result = 1
        for (i in this) result *= i
        return result
    }

    private fun List<Int>.multiplicationCount(numberOfItems: Int): Int {
        var result = 1
        for (i in 0 until numberOfItems) result *= this[i]
        return result
    }

    private fun List<Int>.multiplicationCountPositive(numberOfItems: Int): Int {
        val list = this.filter { i -> i >= 0 }
        var result = 1
        for (i in 0 until numberOfItems) result *= list[i]
        return result
    }
}
