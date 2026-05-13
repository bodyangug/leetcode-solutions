package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumMovesToMakeArrayComplementaryTest {
    private val solution = MinimumMovesToMakeArrayComplementary()

    @Test
    @DisplayName("Example 1: nums = [1,2,4,3], limit = 4 - should return 1")
    fun testExample1() {
        val result = solution.minMoves(intArrayOf(1, 2, 4, 3), 4)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Example 2: nums = [1,2,2,1], limit = 2 - should return 2")
    fun testExample2() {
        val result = solution.minMoves(intArrayOf(1, 2, 2, 1), 2)
        assertEquals(2, result)
    }

    @Test
    @DisplayName("Example 3: nums = [1,2,1,2], limit = 2 - should return 0")
    fun testExample3() {
        val result = solution.minMoves(intArrayOf(1, 2, 1, 2), 2)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Single pair already complementary")
    fun testSinglePair() {
        val result = solution.minMoves(intArrayOf(1, 1), 1)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("All elements equal")
    fun testAllEqual() {
        val result = solution.minMoves(intArrayOf(3, 3, 3, 3), 5)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Single pair needs one move")
    fun testSinglePairOneMoveNeeded() {
        val result = solution.minMoves(intArrayOf(1, 3), 3)
        assertEquals(0, result)
    }
}
