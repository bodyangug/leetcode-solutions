package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchInRotatedSortedArrayTest {
    private val solution = SearchInRotatedSortedArray()

    @Test
    fun `example 1 - target found in rotated array`() {
        assertEquals(4, solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    }

    @Test
    fun `example 2 - target not found in rotated array`() {
        assertEquals(-1, solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    }

    @Test
    fun `example 3 - single element not found`() {
        assertEquals(-1, solution.search(intArrayOf(1), 0))
    }

    @Test
    fun `single element found`() {
        assertEquals(0, solution.search(intArrayOf(1), 1))
    }

    @Test
    fun `target at the beginning`() {
        assertEquals(0, solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 4))
    }

    @Test
    fun `target at the end`() {
        assertEquals(6, solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 2))
    }

    @Test
    fun `no rotation`() {
        assertEquals(3, solution.search(intArrayOf(1, 2, 3, 4, 5, 6, 7), 4))
    }
}
