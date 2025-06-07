package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RotateArrayTest {
    @Test
    fun rotate2_rotatesArray_positiveCase() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val solution = RotateArray()
        solution.rotate2(nums, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums)
    }

    @Test
    fun rotate2_handlesZeroRotation_negativeCase() {
        val nums = intArrayOf(1, 2, 3)
        val solution = RotateArray()
        solution.rotate2(nums, 0)
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }
}
