package days


class Day6 : Day(6) {
    private val allAnswers = inputString.split("\r\n\r\n")

    override fun partOne(): Any {
        return allAnswers.map { it.replace("\r\n", "").toSortedSet().size }
                .toList()
                .sum()
    }

    override fun partTwo(): Any {
        return allAnswers.map { countAllAnswers(it.split("\r\n")) }
                .toList()
                .sum()
    }

    private fun countAllAnswers(answers: List<String>): Int {
        return answers.joinToString("")
                .toSortedSet()
                .filter { uniqueAnswer -> answers.all { it.contains(uniqueAnswer) } }
                .size
    }
}
