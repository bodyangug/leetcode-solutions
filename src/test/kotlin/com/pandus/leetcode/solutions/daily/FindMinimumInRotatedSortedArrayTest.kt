package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumInRotatedSortedArrayTest {
    private val solution = FindMinimumInRotatedSortedArray()

    @Test
    fun `example 1 - rotated 3 times`() {
        assertEquals(1, solution.findMin(intArrayOf(3, 4, 5, 1, 2)))
    }

    @Test
    fun `example 2 - rotated 4 times`() {
        assertEquals(0, solution.findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
    }

    @Test
    fun `example 3 - no effective rotation`() {
        assertEquals(11, solution.findMin(intArrayOf(11, 13, 15, 17)))
    }
}
