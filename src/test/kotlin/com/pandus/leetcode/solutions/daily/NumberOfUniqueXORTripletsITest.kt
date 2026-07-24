package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NumberOfUniqueXORTripletsITest {
    private val solution = NumberOfUniqueXORTripletsI()

    @Test
    @DisplayName("Example 1: nums = [1,2] - should return 2")
    fun testExample1() {
        val nums = intArrayOf(1, 2)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(2, result, "Unique XOR values are {1, 2}")
    }

    @Test
    @DisplayName("Example 2: nums = [3,1,2] - should return 4")
    fun testExample2() {
        val nums = intArrayOf(3, 1, 2)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(4, result, "Unique XOR values are {0, 1, 2, 3}")
    }

    @Test
    @DisplayName("Single element: nums = [1] - should return 1")
    fun testSingleElement() {
        val nums = intArrayOf(1)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(1, result, "Only triplet is 1 XOR 1 XOR 1 = 1")
    }

    @Test
    @DisplayName("n = 4: nums = [1,2,3,4] - should return 8")
    fun testFourElements() {
        val nums = intArrayOf(1, 2, 3, 4)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(8, result, "Smallest power of two greater than 4 is 8")
    }

    @Test
    @DisplayName("n = 5: nums = [5,4,3,2,1] - should return 8")
    fun testFiveElements() {
        val nums = intArrayOf(5, 4, 3, 2, 1)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(8, result, "Smallest power of two greater than 5 is 8")
    }

    @Test
    @DisplayName("n = 7: nums = [1,2,3,4,5,6,7] - should return 8")
    fun testSevenElements() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(8, result, "Smallest power of two greater than 7 is 8")
    }

    @Test
    @DisplayName("n = 8: nums = [1,2,3,4,5,6,7,8] - should return 16")
    fun testEightElements() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(16, result, "Smallest power of two greater than 8 is 16")
    }
}
