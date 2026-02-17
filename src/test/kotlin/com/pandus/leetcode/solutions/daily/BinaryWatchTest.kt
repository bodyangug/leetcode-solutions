package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryWatchTest {
    private val solution = BinaryWatch()

    @Test
    fun `test example 1 - turnedOn equals 1`() {
        val turnedOn = 1
        val expected = listOf("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00")
        assertEquals(expected, solution.readBinaryWatch(turnedOn))
    }

    @Test
    fun `test example 2 - turnedOn equals 9`() {
        val turnedOn = 9
        val expected = emptyList<String>()
        assertEquals(expected, solution.readBinaryWatch(turnedOn))
    }

    @Test
    fun `test turnedOn equals 0`() {
        val turnedOn = 0
        val expected = listOf("0:00")
        assertEquals(expected, solution.readBinaryWatch(turnedOn))
    }

    @Test
    fun `test turnedOn equals 2`() {
        val turnedOn = 2
        val result = solution.readBinaryWatch(turnedOn)
        // Verify some expected values are present
        assert(result.contains("0:03"))
        assert(result.contains("0:05"))
        assert(result.contains("0:09"))
        assert(result.contains("1:01"))
        assert(result.contains("2:01"))
        assert(result.contains("3:00"))
    }

    @Test
    fun `test turnedOn equals 10 - impossible`() {
        val turnedOn = 10
        val expected = emptyList<String>()
        assertEquals(expected, solution.readBinaryWatch(turnedOn))
    }

    @Test
    fun `test turnedOn equals 8 - maximum valid`() {
        val turnedOn = 8
        val result = solution.readBinaryWatch(turnedOn)
        // With 8 LEDs on, we should have very limited options
        assert(
            result.contains("7:31") ||
                    result.contains("11:31") ||
                    result.contains("7:47") ||
                    result.contains("7:55")
        )
    }
}
