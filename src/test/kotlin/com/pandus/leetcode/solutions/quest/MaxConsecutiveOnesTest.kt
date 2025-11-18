package com.pandus.leetcode.solutions.quest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxConsecutiveOnesTest {
    private val solution = MaxConsecutiveOnes()

    @Test
    fun `should find max consecutive ones in mixed array`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1))
        assertEquals(3, result)
    }

    @Test
    fun `should find max consecutive ones when array has alternating values`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0, 1))
        assertEquals(2, result)
    }

    @Test
    fun `should return 0 when array contains only zeros`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(0, 0, 0, 0))
        assertEquals(0, result)
    }

    @Test
    fun `should return array length when array contains only ones`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 1, 1))
        assertEquals(5, result)
    }

    @Test
    fun `should handle single element array with one`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(1))
        assertEquals(1, result)
    }

    @Test
    fun `should handle single element array with zero`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(0))
        assertEquals(0, result)
    }

    @Test
    fun `should find max consecutive ones at the beginning`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 0, 1, 0))
        assertEquals(3, result)
    }

    @Test
    fun `should find max consecutive ones at the end`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(0, 1, 0, 1, 1, 1, 1))
        assertEquals(4, result)
    }

    @Test
    fun `should handle array starting with zero`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(0, 1, 1, 0, 1))
        assertEquals(2, result)
    }

    @Test
    fun `should handle array ending with zero`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 0))
        assertEquals(3, result)
    }

    @Test
    fun `should handle multiple sequences with same length`() {
        val result = solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 0, 1, 1))
        assertEquals(2, result)
    }
}
