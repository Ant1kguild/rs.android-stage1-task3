package subtask1

import kotlin.math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {

        return when (val arraySize = numbers.count()) {
            0 -> null
            else -> getFunc(numbers)
        }
    }

    private fun getFunc(numbers: Array<Int>): String {
        val size = numbers.size
        val result = StringBuilder()
        for (value in numbers.indices) {
            val degree = size - (1 + value)
            val currentNumber = numbers[value]
            val absNumber = abs(currentNumber)

            if (currentNumber != 0) {
                if (currentNumber > 0) {
                    if (degree == size - 1)
                        result.append("")
                    else
                        result.append(" + ")
                } else {
                    if (degree == size - 1)
                        result.append("-")
                    else
                        result.append(" - ")
                }
                if (absNumber > 1)
                    result.append(absNumber)
                if (degree > 1)
                    result.append("x^$degree")
                else if (degree != 0)
                    result.append("x")
            }

        }

        return result.toString()
    }
}
