package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FindNumberOfSubsequencesWithEqualGCDTest {
    private val solution = FindNumberOfSubsequencesWithEqualGCD()

    @Test
    @DisplayName("Example 1: nums = [1,2,3,4]")
    fun testExample1() {
        val result = solution.subsequencePairCount(intArrayOf(1, 2, 3, 4))
        assertEquals(10, result, "Should return 10 pairs with equal GCD of 1")
    }

    @Test
    @DisplayName("Example 2: nums = [10,20,30]")
    fun testExample2() {
        val result = solution.subsequencePairCount(intArrayOf(10, 20, 30))
        assertEquals(2, result, "Should return 2 pairs with equal GCD of 10")
    }

    @Test
    @DisplayName("Example 3: nums = [1,1,1,1]")
    fun testExample3() {
        val result = solution.subsequencePairCount(intArrayOf(1, 1, 1, 1))
        assertEquals(50, result, "Should return 50 pairs")
    }

    @Test
    @DisplayName("Single element: nums = [5]")
    fun testSingleElement() {
        val result = solution.subsequencePairCount(intArrayOf(5))
        assertEquals(0, result, "Cannot form disjoint non-empty pairs from a single element")
    }

    @Test
    @DisplayName("Two equal elements: nums = [7,7]")
    fun testTwoEqualElements() {
        val result = solution.subsequencePairCount(intArrayOf(7, 7))
        assertEquals(2, result, "Two ordered pairs: ([a],[b]) and ([b],[a])")
    }

    @Test
    @DisplayName("Two coprime elements: nums = [2,3]")
    fun testTwoCoprimeElements() {
        val result = solution.subsequencePairCount(intArrayOf(2, 3))
        assertEquals(0, result, "GCD 2 and GCD 3 are never equal for disjoint singletons")
    }
}
