package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        val inp = inputList.map { it.toInt() }
        for (num1 in inp) {
            for (num2 in inp) {
                if ((num1 + num2) == 2020) {
                    return (num1 * num2)
                }
            }
        }
        return -1
    }

    override fun partTwo(): Any {
        val inp = inputList.map { it.toInt() }
        for (num1 in inp) {
            for (num2 in inp) {
                for (num3 in inp) {
                    if ((num1 + num2 + num3) == 2020) {
                        return (num1 * num2 * num3)
                    }
                }
            }
        }
        return -1
    }
}
