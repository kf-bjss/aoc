package days

import kotlin.math.abs

class Day3 : Day(3) {

    override fun partOne(): Any {
        return countTrees(3, 1, inputList)
    }

    override fun partTwo(): Any {
        val treeCountForEachSlope: MutableList<Int> = ArrayList()
        val slopeList: MutableList<Coordinate> = ArrayList()

        slopeList.add(Coordinate(1, 1))
        slopeList.add(Coordinate(3, 1))
        slopeList.add(Coordinate(5, 1))
        slopeList.add(Coordinate(7, 1))
        slopeList.add(Coordinate(1, 2))

        slopeList.forEach { slope ->
            treeCountForEachSlope.add(countTrees(slope.x, slope.y, inputList))
        }

        return treeCountForEachSlope.reduce { acc, i -> acc * i }
    }

    fun countTrees(stepX: Int, stepY: Int, coords: List<String>): Int {
        var treeCount = 0
        var x = stepX
        for (y in stepY until coords.size step stepY) {
            if (coords[y][x] == '#') {
                treeCount++
            }
            x += stepX
            if (x >= coords[y].length) {
                x = abs((coords[y].length - x))
            }
        }
        return treeCount
    }
}

data class Coordinate(val x: Int, val y: Int)
