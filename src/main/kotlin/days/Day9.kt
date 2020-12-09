package days


class Day9 : Day(9) {
    private val numbers = inputList.map { it.toLong() }

    override fun partOne(): Long {
        return numbers.filterIndexed{ index, num -> index >= 25 && !hasSum(index, num, numbers) }.first()
    }

    override fun partTwo(): Long {
        var result = 0L
        val partOneResult = partOne()

        for(n in numbers.indices) {
            var sum = 0L
            for (m in n until numbers.size) {
                sum += numbers[m]
                if(sum == partOneResult) {
                    val list2 = numbers.subList(n, m).sorted()
                    result = list2.first()+list2.last()
                    return result
                }

                if(sum > partOneResult) {
                    break
                }
            }
        }

        return result
    }

    private fun hasSum(currIndex: Int, value: Long, list1: List<Long>): Boolean {
        for(n in currIndex-25 until currIndex) {
            for (m in currIndex-25 until currIndex) {
                val l = list1[n]
                val l1 = list1[m]

                if(l != l1 && (l + l1) == value) {
                    return true
                }

            }
        }
        return false
    }
}
