package days


class Day8 : Day(8) {
    private val instructions: Map<Int, Pair<String, Int>> = inputList.mapIndexed { index, ins ->
        val (code, num) = ins.split(" ")
        index to Pair(code, num.toInt())
    }.toMap()

    override fun partOne(): Int {
        return calcAcc().first
    }

    override fun partTwo(): Int {
        var result = 0
        instructions.filter { it.value.first in arrayOf("jmp", "nop") }.keys.forEach {
            val calcAcc = calcAcc(it)
            if (calcAcc.second == inputList.size) {
                result = calcAcc.first
            }
        }
        return result
    }

    private fun calcAcc(off: Int = -1): Pair<Int, Int> {
        var accumulator = 0
        var index = 0
        val executedCode: MutableSet<Int> = HashSet()
        while (index < inputList.size) {
            var (code, num) = instructions[index] ?: error("Not found")

            if (off >= 0 && index == off) {
                code = if (code == "nop") "jmp" else "nop"
            }

            if (executedCode.contains(index)) {
                break
            }
            executedCode.add(index)

            when (code) {
                "acc" -> {
                    accumulator += num
                    index++
                }
                "jmp" -> index += num
                "nop" -> index++
            }
        }
        return Pair(accumulator, index)
    }
}
