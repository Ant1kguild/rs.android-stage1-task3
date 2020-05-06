package subtask4

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return decomposer(number.square(), number - 1)
    }

    private fun decomposer(first: Int, second: Int): Array<Int>? {
        for (i in second downTo 1) {
            val square = i.square()
            val residue = first.residue(square)

            if (residue == 0) return arrayOf(i)
            if (residue < 0) return null

            var value = sqrt(residue.toDouble()).toInt()
            if (value >= i) value = i - 1

            decomposer(residue, value)?.let { return it.plus(i) }
        }
        return null
    }

    private fun Int.square() = this * this
    private fun Int.residue(value: Int) = this - value
    private fun Array<Int>.plus(value: Int) = this + arrayOf(value)
}



