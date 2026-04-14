package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDistanceToTargetElementTest {
    private val solution = MinimumDistanceToTargetElement()

    @Test
    fun `test example 1 - single occurrence at the end`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val target = 5
        val start = 3
        assertEquals(1, solution.getMinDistance(nums, target, start))
    }

    @Test
    fun `test example 2 - single element array`() {
        val nums = intArrayOf(1)
        val target = 1
        val start = 0
        assertEquals(0, solution.getMinDistance(nums, target, start))
    }

    @Test
    fun `test example 3 - multiple occurrences, closest is at start`() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        val target = 1
        val start = 0
        assertEquals(0, solution.getMinDistance(nums, target, start))
    }

    @Test
    fun `test target at start index`() {
        val nums = intArrayOf(3, 7, 2, 3, 5)
        val target = 3
        val start = 3
        assertEquals(0, solution.getMinDistance(nums, target, start))
    }

    @Test
    fun `test multiple occurrences, picks closer one`() {
        val nums = intArrayOf(5, 3, 6, 5, 7)
        val target = 5
        val start = 3
        assertEquals(0, solution.getMinDistance(nums, target, start))
    }

    @Test
    fun `test target only at the beginning`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val target = 1
        val start = 4
        assertEquals(4, solution.getMinDistance(nums, target, start))
    }
}
