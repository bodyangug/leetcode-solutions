package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NumberOfUniqueXORTripletsIITest {
    private val solution = NumberOfUniqueXORTripletsII()

    @Test
    @DisplayName("Example 1: nums = [1,3] - should return 2")
    fun testExample1() {
        val nums = intArrayOf(1, 3)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(2, result, "Unique XOR values are {1, 3}")
    }

    @Test
    @DisplayName("Example 2: nums = [6,7,8,9] - should return 4")
    fun testExample2() {
        val nums = intArrayOf(6, 7, 8, 9)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(4, result, "Unique XOR values are {6, 7, 8, 9}")
    }

    @Test
    @DisplayName("Single element: nums = [1] - should return 1")
    fun testSingleElement() {
        val nums = intArrayOf(1)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(1, result, "Only triplet is 1 XOR 1 XOR 1 = 1")
    }

    @Test
    @DisplayName("Two equal elements: nums = [5,5] - should return 1")
    fun testTwoEqualElements() {
        val nums = intArrayOf(5, 5)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(1, result, "Only possible value is 5")
    }

    @Test
    @DisplayName("Duplicates collapse: nums = [1,3,3,1] - should return 2")
    fun testDuplicates() {
        val nums = intArrayOf(1, 3, 3, 1)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(2, result, "Duplicates don't add new values, {1, 3}")
    }

    @Test
    @DisplayName("Includes zero: nums = [0,1,2] - should return 4")
    fun testIncludesZero() {
        val nums = intArrayOf(0, 1, 2)
        val result = solution.uniqueXorTriplets(nums)
        assertEquals(4, result, "Unique XOR values are {0, 1, 2, 3}")
    }
}
