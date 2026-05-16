package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumInRotatedSortedArrayIITest {
    private val solution = FindMinimumInRotatedSortedArrayII()

    @Test
    fun `example 1 - no rotation with duplicates`() {
        assertEquals(1, solution.findMin(intArrayOf(1, 3, 5)))
    }

    @Test
    fun `example 2 - rotated with duplicates`() {
        assertEquals(0, solution.findMin(intArrayOf(2, 2, 2, 0, 1)))
    }

    @Test
    fun `single element`() {
        assertEquals(1, solution.findMin(intArrayOf(1)))
    }

    @Test
    fun `all duplicates`() {
        assertEquals(2, solution.findMin(intArrayOf(2, 2, 2, 2, 2)))
    }

    @Test
    fun `duplicates at boundaries`() {
        assertEquals(0, solution.findMin(intArrayOf(4, 5, 6, 7, 0, 1, 4)))
    }
}
