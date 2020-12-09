package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day9Test {

    private val thisDay = Day9()

    @Test
    fun testPartOne() {
        assertThat(thisDay.partOne(), `is`(507622668))
    }

    @Test
    fun testPartTwo() {
        val partTwo = thisDay.partTwo()
        assertThat(partTwo, `is`(76688505))
    }
}
