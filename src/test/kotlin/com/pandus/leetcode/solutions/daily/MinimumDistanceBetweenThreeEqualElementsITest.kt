package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDistanceBetweenThreeEqualElementsITest {
    private val solution = MinimumDistanceBetweenThreeEqualElementsI()

    @Test
    fun `test example 1 - minimum distance is 6`() {
        val nums = intArrayOf(1, 2, 1, 1, 3)
        assertEquals(6, solution.minimumDistance(nums))
    }

    @Test
    fun `test example 2 - minimum distance is 8`() {
        val nums = intArrayOf(1, 1, 2, 3, 2, 1, 2)
        assertEquals(8, solution.minimumDistance(nums))
    }

    @Test
    fun `test example 3 - single element returns -1`() {
        val nums = intArrayOf(1)
        assertEquals(-1, solution.minimumDistance(nums))
    }

    @Test
    fun `test no good tuple exists returns -1`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(-1, solution.minimumDistance(nums))
    }

    @Test
    fun `test exactly three equal elements consecutive`() {
        val nums = intArrayOf(1, 1, 1)
        assertEquals(4, solution.minimumDistance(nums))
    }

    @Test
    fun `test three equal elements at start middle and end`() {
        val nums = intArrayOf(5, 0, 0, 5, 0, 5)
        assertEquals(6, solution.minimumDistance(nums))
    }

    @Test
    fun `test multiple groups pick the closest one`() {
        val nums = intArrayOf(1, 2, 1, 1, 2, 2, 3)
        assertEquals(6, solution.minimumDistance(nums))
    }

    @Test
    fun `test all elements the same`() {
        val nums = intArrayOf(7, 7, 7, 7)
        assertEquals(4, solution.minimumDistance(nums))
    }

    @Test
    fun `test two pairs but only one value has three occurrences`() {
        val nums = intArrayOf(1, 1, 2, 2, 1)
        assertEquals(8, solution.minimumDistance(nums))
    }

    @Test
    fun `test only two occurrences of any value returns -1`() {
        val nums = intArrayOf(1, 1, 2, 2, 3, 3)
        assertEquals(-1, solution.minimumDistance(nums))
    }
}
