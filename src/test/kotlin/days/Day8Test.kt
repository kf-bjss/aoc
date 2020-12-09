package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day8Test {

    private val thisDay = Day8()

    @Test
    fun testPartOne() {
        assertThat(thisDay.partOne(), `is`(1563))
    }

    @Test
    fun testPartTwo() {
        val partTwo = thisDay.partTwo()
        assertThat(partTwo, `is`(767))
    }
}
