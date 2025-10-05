package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSumTest {

    private val solution = TwoSum()

    @Test
    fun testExample1() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = solution.twoSum(nums, target)
        assertArrayEquals(intArrayOf(0, 1), result)
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val result = solution.twoSum(nums, target)
        assertArrayEquals(intArrayOf(1, 2), result)
    }

    @Test
    fun testExample3() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val result = solution.twoSum(nums, target)
        assertArrayEquals(intArrayOf(0, 1), result)
    }

    @Test
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -2, -3, -4, -5)
        val target = -8
        val result = solution.twoSum(nums, target)
        assertArrayEquals(intArrayOf(2, 4), result)
    }

    @Test
    fun testNoSolution() {
        val nums = intArrayOf(1, 2, 3)
        val target = 10
        val result = solution.twoSum(nums, target)
        assertArrayEquals(intArrayOf(-1, -1), result)
    }

    @Test
    fun testSinglePair() {
        val nums = intArrayOf(5, 5)
        val target = 10
        val result = solution.twoSum(nums, target)
        assertArrayEquals(intArrayOf(0, 1), result)
    }
}
