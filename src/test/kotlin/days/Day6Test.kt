package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day6Test {

    private val thisDay = Day6()

    @Test
    fun testPartOne() {
        assertThat(thisDay.partOne(), `is`(6259))
    }

    @Test
    fun testPartTwo() {
        val partTwo = thisDay.partTwo()
        assertThat(partTwo, `is`(3178))
    }
}
