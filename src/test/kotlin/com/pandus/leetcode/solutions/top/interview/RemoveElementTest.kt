package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RemoveElementTest {

    private val solution = RemoveElement()

    @Test
    fun testExample1() {
        val nums = intArrayOf(3, 2, 2, 3)
        val result = solution.removeElement(nums, 3)
        assertEquals(2, result)
        // First 2 elements should be 2, 2 (order doesn't matter)
        assertTrue(nums.take(result).all { it == 2 })
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val result = solution.removeElement(nums, 2)
        assertEquals(5, result)
        // First 5 elements should not contain 2
        assertTrue(nums.take(result).none { it == 2 })
    }

    @Test
    fun testNoElementsToRemove() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.removeElement(nums, 6)
        assertEquals(5, result)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), nums)
    }

    @Test
    fun testAllElementsToRemove() {
        val nums = intArrayOf(2, 2, 2, 2)
        val result = solution.removeElement(nums, 2)
        assertEquals(0, result)
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(3)
        val result = solution.removeElement(nums, 3)
        assertEquals(0, result)
    }

    @Test
    fun testEmptyArray() {
        val nums = intArrayOf()
        val result = solution.removeElement(nums, 1)
        assertEquals(0, result)
    }
}
