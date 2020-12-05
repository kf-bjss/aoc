package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day5Test {

    private val thisDay = Day5()

    @Test
    fun testPartOne() {
        assertThat(thisDay.partOne(), `is`(871))
    }

    @Test
    fun testPartTwo() {
        val partTwo = thisDay.partTwo()
        assertThat(partTwo, `is`(640))
    }
}
