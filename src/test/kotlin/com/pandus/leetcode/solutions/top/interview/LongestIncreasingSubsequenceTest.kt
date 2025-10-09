package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestIncreasingSubsequenceTest {

    private val solution = LongestIncreasingSubsequence()

    @Test
    fun testExample1() {
        val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
        assertEquals(4, solution.lengthOfLIS(nums)) // [2,3,7,18]
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(0, 1, 0, 3, 2, 3)
        assertEquals(4, solution.lengthOfLIS(nums)) // [0,1,2,3]
    }

    @Test
    fun testExample3() {
        val nums = intArrayOf(7, 7, 7, 7, 7, 7, 7)
        assertEquals(1, solution.lengthOfLIS(nums)) // Any single element
    }

    @Test
    fun testIncreasingSequence() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(5, solution.lengthOfLIS(nums)) // Entire array
    }

    @Test
    fun testDecreasingSequence() {
        val nums = intArrayOf(5, 4, 3, 2, 1)
        assertEquals(1, solution.lengthOfLIS(nums)) // Any single element
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(1)
        assertEquals(1, solution.lengthOfLIS(nums))
    }

    @Test
    fun testNegativeNumbers() {
        val nums = intArrayOf(-10, -5, -3, -1, 0, 2)
        assertEquals(6, solution.lengthOfLIS(nums)) // Entire array
    }

    @Test
    fun testMixedPattern() {
        val nums = intArrayOf(1, 3, 2, 4, 5)
        assertEquals(4, solution.lengthOfLIS(nums)) // [1,2,4,5] or [1,3,4,5]
    }

    @Test
    fun testTwoElements() {
        val nums = intArrayOf(1, 2)
        assertEquals(2, solution.lengthOfLIS(nums))
    }

    @Test
    fun testTwoElementsDecreasing() {
        val nums = intArrayOf(2, 1)
        assertEquals(1, solution.lengthOfLIS(nums))
    }

    @Test
    fun testComplexPattern() {
        val nums = intArrayOf(4, 10, 4, 3, 8, 9)
        assertEquals(3, solution.lengthOfLIS(nums)) // [4,8,9]
    }

    @Test
    fun testDuplicatesWithIncreasing() {
        val nums = intArrayOf(1, 1, 2, 2, 3, 3)
        assertEquals(3, solution.lengthOfLIS(nums)) // [1,2,3]
    }

}
