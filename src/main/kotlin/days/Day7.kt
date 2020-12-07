package days


class Day7 : Day(7) {
    private val bagsAndContents: Map<String, List<Bag>> = inputList.filter { !it.contains("no other bags") }
            .associate { line ->
                val (color, content) = line.replace(Regex("bags|bag|[.]"), "").split("contain")
                color.trim() to content.split(",")
                        .map {
                            val quantity = it.substring(0, 3).trim().toInt()
                            val bagName = it.substring(3).trim()
                            Bag(bagName, quantity)
                        }.toList()
            }

    override fun partOne(): Any {
        return bagsAndContents.keys.filter { hasGold(it, bagsAndContents) }.size
    }

    override fun partTwo(): Any {
        return countBags(bagsAndContents["shiny gold"], bagsAndContents)
    }

    private fun hasGold(color: String, map: Map<String, List<Bag>>): Boolean {
        return map[color]?.any { it.name == "shiny gold" } ?: false || map[color]?.any { hasGold(it.name, map) } ?: false
    }

    private fun countBags(bagList: List<Bag>?, map: Map<String, List<Bag>>): Int {
        return bagList?.sumBy { it.quantity + (it.quantity * countBags(map[it.name], map)) } ?: 0
    }

    data class Bag(val name: String, val quantity: Int)
}
