package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ThreeSumTest {

    private val solution = ThreeSum()

    @Test
    fun testExample1() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val result = solution.threeSum(nums)
        assertEquals(2, result.size)
        assertTrue(result.contains(listOf(-1, -1, 2)))
        assertTrue(result.contains(listOf(-1, 0, 1)))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(0, 1, 1)
        val result = solution.threeSum(nums)
        assertTrue(result.isEmpty())
    }

    @Test
    fun testExample3() {
        val nums = intArrayOf(0, 0, 0)
        val result = solution.threeSum(nums)
        assertEquals(1, result.size)
        assertTrue(result.contains(listOf(0, 0, 0)))
    }

    @Test
    fun testNoDuplicates() {
        val nums = intArrayOf(-2, 0, 1, 1, 2)
        val result = solution.threeSum(nums)
        assertEquals(2, result.size)
        assertTrue(result.contains(listOf(-2, 0, 2)))
        assertTrue(result.contains(listOf(-2, 1, 1)))
    }

    @Test
    fun testAllPositive() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.threeSum(nums)
        assertTrue(result.isEmpty())
    }

    @Test
    fun testAllNegative() {
        val nums = intArrayOf(-5, -4, -3, -2, -1)
        val result = solution.threeSum(nums)
        assertTrue(result.isEmpty())
    }
}
