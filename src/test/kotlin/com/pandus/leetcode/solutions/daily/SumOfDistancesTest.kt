package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SumOfDistancesTest {
    private val solution = SumOfDistances()

    @Test
    @DisplayName("Example 1: nums = [1,3,1,1,2] - should return [5,0,3,4,0]")
    fun testExample1() {
        val nums = intArrayOf(1, 3, 1, 1, 2)
        assertArrayEquals(longArrayOf(5, 0, 3, 4, 0), solution.distance(nums))
    }

    @Test
    @DisplayName("Example 2: nums = [0,5,3] - should return [0,0,0]")
    fun testExample2() {
        val nums = intArrayOf(0, 5, 3)
        assertArrayEquals(longArrayOf(0, 0, 0), solution.distance(nums))
    }

    @Test
    @DisplayName("Single element: nums = [1] - should return [0]")
    fun testSingleElement() {
        val nums = intArrayOf(1)
        assertArrayEquals(longArrayOf(0), solution.distance(nums))
    }

    @Test
    @DisplayName("All same values: nums = [1,1,1] - should return [3,2,3]")
    fun testAllSameValues() {
        val nums = intArrayOf(1, 1, 1)
        assertArrayEquals(longArrayOf(3, 2, 3), solution.distance(nums))
    }

    @Test
    @DisplayName("Two elements same: nums = [2,2] - should return [1,1]")
    fun testTwoSameElements() {
        val nums = intArrayOf(2, 2)
        assertArrayEquals(longArrayOf(1, 1), solution.distance(nums))
    }

    @Test
    @DisplayName("Two distinct elements: nums = [1,2] - should return [0,0]")
    fun testTwoDistinctElements() {
        val nums = intArrayOf(1, 2)
        assertArrayEquals(longArrayOf(0, 0), solution.distance(nums))
    }
}
