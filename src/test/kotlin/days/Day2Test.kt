package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day2Test {

    private val dayTwo = Day2()

    @Test
    fun testPartOne() {
        assertThat(dayTwo.partOne(), `is`(640))
    }

    @Test
    fun testPartTwo() {
        val partTwo = dayTwo.partTwo()
        assertThat(partTwo, `is`(472))
    }
}
