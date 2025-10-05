package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RotateArrayTest {

    private val solution = RotateArray()

    @Test
    fun testRotate2Example1() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        solution.rotate2(nums, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums)
    }

    @Test
    fun testRotate2Example2() {
        val nums = intArrayOf(-1, -100, 3, 99)
        solution.rotate2(nums, 2)
        assertArrayEquals(intArrayOf(3, 99, -1, -100), nums)
    }

    @Test
    fun testRotate2NoRotation() {
        val nums = intArrayOf(1, 2, 3, 4)
        solution.rotate2(nums, 0)
        assertArrayEquals(intArrayOf(1, 2, 3, 4), nums)
    }

    @Test
    fun testRotate2FullRotation() {
        val nums = intArrayOf(1, 2, 3, 4)
        solution.rotate2(nums, 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4), nums)
    }

    @Test
    fun testRotate2LargeK() {
        val nums = intArrayOf(1, 2, 3)
        solution.rotate2(nums, 5) // k > nums.size
        assertArrayEquals(intArrayOf(2, 3, 1), nums)
    }

    @Test
    fun testRotate2SingleElement() {
        val nums = intArrayOf(1)
        solution.rotate2(nums, 3)
        assertArrayEquals(intArrayOf(1), nums)
    }
}
