package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArray2Test {

    private val solution = RemoveDuplicatesFromSortedArray2()

    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        val result = solution.removeDuplicates(nums)
        assertEquals(5, result)
        assertArrayEquals(intArrayOf(1, 1, 2, 2, 3), nums.take(result).toIntArray())
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        val result = solution.removeDuplicates(nums)
        assertEquals(7, result)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 3, 3), nums.take(result).toIntArray())
    }

    @Test
    fun testNoDuplicates() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.removeDuplicates(nums)
        assertEquals(5, result)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), nums)
    }

    @Test
    fun testAllSame() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val result = solution.removeDuplicates(nums)
        assertEquals(2, result)
        assertEquals(1, nums[0])
        assertEquals(1, nums[1])
    }

    @Test
    fun testShortArray() {
        val nums = intArrayOf(1, 1)
        val result = solution.removeDuplicates(nums)
        assertEquals(2, result)
        assertArrayEquals(intArrayOf(1, 1), nums)
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(1)
        val result = solution.removeDuplicates(nums)
        assertEquals(1, result)
        assertEquals(1, nums[0])
    }
}
