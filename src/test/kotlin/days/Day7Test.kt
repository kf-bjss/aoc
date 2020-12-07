package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day7Test {

    private val thisDay = Day7()

    @Test
    fun testPartOne() {
        assertThat(thisDay.partOne(), `is`(335))
    }

    @Test
    fun testPartTwo() {
        val partTwo = thisDay.partTwo()
        assertThat(partTwo, `is`(2431))
    }
}
