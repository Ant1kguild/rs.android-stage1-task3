package subtask2

class Combinator {


    fun checkChooseFromArray(array: Array<Int>): Int? {
        val combinations = array[0]
        val elements = array[1]


        for (i in 1 until elements) {
            if (factorial(i) * factorial(elements - i) == factorial(elements) / combinations)
                return i
        }
        return null
    }

    private fun factorial(number: Int): Long {
        return when (number) {
            0 -> 1
            else -> number * factorial(number - 1)
        }
    }
}
