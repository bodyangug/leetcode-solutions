package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AvoidFloodInTheCityTest {

    private val solution = AvoidFloodInTheCity()

    @Test
    fun `test basic case with successful flood avoidance`() {
        val rains = intArrayOf(1, 2, 3, 4)
        val result = solution.avoidFlood(rains)
        val expected = intArrayOf(-1, -1, -1, -1)
        assertArrayEquals(expected, result)
    }

    @Test
    fun `test case with dry days and flood avoidance`() {
        val rains = intArrayOf(1, 2, 0, 0, 2, 1)
        val result = solution.avoidFlood(rains)

        // Verify structure: rainy days should be -1, dry days should have valid lake numbers
        assertEquals(-1, result[0]) // lake 1 fills
        assertEquals(-1, result[1]) // lake 2 fills
        assertTrue(result[2] > 0) // dry day, should dry some lake
        assertTrue(result[3] > 0) // dry day, should dry some lake
        assertEquals(-1, result[4]) // lake 2 fills again
        assertEquals(-1, result[5]) // lake 1 fills again

        // Verify no flood occurs by checking the logic
        assertFalse(result.isEmpty())
    }

    @Test
    fun `test impossible case - flood unavoidable`() {
        val rains = intArrayOf(1, 2, 1, 2)
        val result = solution.avoidFlood(rains)
        assertArrayEquals(intArrayOf(), result)
    }

    @Test
    fun `test single lake multiple rains with dry days`() {
        val rains = intArrayOf(1, 0, 1, 0, 1)
        val result = solution.avoidFlood(rains)

        assertEquals(-1, result[0]) // lake 1 fills
        assertEquals(1, result[1]) // dry lake 1
        assertEquals(-1, result[2]) // lake 1 fills again
        assertEquals(1, result[3]) // dry lake 1 again
        assertEquals(-1, result[4]) // lake 1 fills again
    }

    @Test
    fun `test complex case with multiple lakes`() {
        val rains = intArrayOf(1, 2, 0, 3, 0, 2, 1)
        val result = solution.avoidFlood(rains)

        // Should find a valid solution
        assertFalse(result.isEmpty())

        // Verify rainy days are -1
        assertEquals(-1, result[0])
        assertEquals(-1, result[1])
        assertEquals(-1, result[3])
        assertEquals(-1, result[5])
        assertEquals(-1, result[6])

        // Verify dry days have positive values
        assertTrue(result[2] > 0)
        assertTrue(result[4] > 0)
    }

    @Test
    fun `test edge case - empty array`() {
        val rains = intArrayOf()
        val result = solution.avoidFlood(rains)
        assertArrayEquals(intArrayOf(), result)
    }

    @Test
    fun `test only dry days`() {
        val rains = intArrayOf(0, 0, 0)
        val result = solution.avoidFlood(rains)

        // All should be 1 (placeholder for unused dry days)
        assertArrayEquals(intArrayOf(1, 1, 1), result)
    }

    @Test
    fun `test greedy strategy effectiveness`() {
        val rains = intArrayOf(1, 2, 0, 0, 2, 1)
        val result = solution.avoidFlood(rains)

        // Should successfully avoid flood
        assertFalse(result.isEmpty())

        // The algorithm should use dry days strategically
        // Day 2 or 3 should be used to dry lake 2 before day 4
        // The remaining dry day should be used to dry lake 1 before day 5
        assertTrue((result[2] == 2 && result[3] == 1) || (result[2] == 1 && result[3] == 2))
    }

    @Test
    fun `test case where timing matters`() {
        val rains = intArrayOf(1, 0, 2, 0, 2, 1)
        val result = solution.avoidFlood(rains)

        // Should find valid solution
        assertFalse(result.isEmpty())

        // Lake 2 needs to be dried on day 3 (index 3) to avoid flood on day 4 (index 4)
        // Lake 1 can be dried on day 1 (index 1) for the flood on day 5 (index 5)
        assertEquals(1, result[1]) // dry lake 1 on day 1
        assertEquals(2, result[3]) // dry lake 2 on day 3
    }
}
