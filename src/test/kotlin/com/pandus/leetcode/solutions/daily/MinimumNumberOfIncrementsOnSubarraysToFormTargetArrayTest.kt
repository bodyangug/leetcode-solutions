package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumNumberOfIncrementsOnSubarraysToFormTargetArrayTest {

    private val solution = MinimumNumberOfIncrementsOnSubarraysToFormTargetArray()

    @Test
    @DisplayName("Basic case with increasing values")
    fun minNumberOperations_increasingArray() {
        val target = intArrayOf(1, 2, 3, 2, 1)
        val result = solution.minNumberOperations(target)
        assertEquals(3, result, "Should return 3 for target [1,2,3,2,1]")
    }

    @Test
    @DisplayName("Basic case with all same values")
    fun minNumberOperations_sameValues() {
        val target = intArrayOf(3, 3, 3)
        val result = solution.minNumberOperations(target)
        assertEquals(3, result, "Should return 3 for target [3,3,3]")
    }

    @Test
    @DisplayName("Basic case with strictly increasing values")
    fun minNumberOperations_strictlyIncreasing() {
        val target = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.minNumberOperations(target)
        assertEquals(5, result, "Should return 5 for target [1,2,3,4,5]")
    }

    @Test
    @DisplayName("Edge case with single element")
    fun minNumberOperations_singleElement() {
        val target = intArrayOf(5)
        val result = solution.minNumberOperations(target)
        assertEquals(5, result, "Should return 5 for single element array [5]")
    }

    @Test
    @DisplayName("Edge case with decreasing values")
    fun minNumberOperations_decreasingArray() {
        val target = intArrayOf(5, 4, 3, 2, 1)
        val result = solution.minNumberOperations(target)
        assertEquals(5, result, "Should return 5 for decreasing target [5,4,3,2,1]")
    }
}
