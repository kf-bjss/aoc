package days

import kotlin.math.ceil


class Day5 : Day(5) {
    private val ticketIdList = calcSortedTicketIdList(inputList)

    override fun partOne(): Any {
        return ticketIdList.last()
    }

    override fun partTwo(): Any {
        return (ticketIdList.first()..ticketIdList.last()).first { it !in ticketIdList }
    }

    private fun calcSortedTicketIdList(ticketList: List<String>): MutableList<Int> {
        val idList: MutableList<Int> = ticketList.map { calcTicketId(it) }.toMutableList()
        idList.sort()
        return idList
    }

    private fun calcTicketId(ticket: String): Int {
        var rowLower = 0
        var rowUpper = 127
        var colLower = 0
        var colUpper = 7
        var rowId = 0
        var colId = 0
        ticket.forEach {
            when (it) {
                'F' -> {
                    rowUpper -= calcChange(rowUpper, rowLower)
                    rowId = rowLower
                }
                'B' -> {
                    rowLower += calcChange(rowUpper, rowLower)
                    rowId = rowUpper
                }
                'L' -> {
                    colUpper -= calcChange(colUpper, colLower)
                    colId = colUpper
                }
                'R' -> {
                    colLower += calcChange(colUpper, colLower)
                    colId = colLower
                }
            }
        }

        return rowId * 8 + colId
    }

    private fun calcChange(upper: Int, lower: Int): Int {
        return divideCeil(upper - lower)
    }

    private fun divideCeil(r: Int): Int {
        return ceil(r.div(2.0)).toInt()
    }
}
