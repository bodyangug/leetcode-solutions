package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfGCDOfFormedPairsTest {
    private val solution = SumOfGCDOfFormedPairs()

    @Test
    fun `example 1`() {
        assertEquals(2L, solution.gcdSum(intArrayOf(2, 6, 4)))
    }

    @Test
    fun `example 2`() {
        assertEquals(5L, solution.gcdSum(intArrayOf(3, 6, 2, 8)))
    }

    @Test
    fun `single element is ignored`() {
        assertEquals(0L, solution.gcdSum(intArrayOf(7)))
    }

    @Test
    fun `two equal elements`() {
        assertEquals(5L, solution.gcdSum(intArrayOf(5, 5)))
    }

    @Test
    fun `two coprime elements`() {
        assertEquals(1L, solution.gcdSum(intArrayOf(3, 4)))
    }

    @Test
    fun `all identical elements`() {
        assertEquals(12L, solution.gcdSum(intArrayOf(6, 6, 6, 6)))
    }

    @Test
    fun `odd length middle element ignored`() {
        assertEquals(4L, solution.gcdSum(intArrayOf(4, 2, 8, 6, 10)))
    }

    @Test
    fun `ascending input`() {
        assertEquals(2L, solution.gcdSum(intArrayOf(1, 2, 3, 6)))
    }
}
