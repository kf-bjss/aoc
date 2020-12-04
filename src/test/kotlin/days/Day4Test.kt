package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day4Test {

    private val thisDay = Day4()

    @Test
    fun testPartOne() {
        assertThat(thisDay.partOne(), `is`(264))
    }

    @Test
    fun testPartTwo() {
        val partTwo = thisDay.partTwo()
        assertThat(partTwo, `is`(224))
    }
}
