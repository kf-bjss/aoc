package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day1Test {

    private val dayOne = Day1()

    @Test
    fun testPartOne() {
        assertThat(dayOne.partOne(), `is`(658899))
    }

    @Test
    fun testPartTwo() {
        val partTwo = dayOne.partTwo()
        assertThat(partTwo, `is`(155806250))
    }
}
