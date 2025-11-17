package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CheckIfAll1sAreAtLeastLengthKPlacesAwayTest {

    private val solution = CheckIfAll1sAreAtLeastLengthKPlacesAway()

    @Test
    @DisplayName("Example 1: nums = [1,0,0,0,1,0,0,1], k = 2")
    fun testExample1() {
        val nums = intArrayOf(1, 0, 0, 0, 1, 0, 0, 1)
        val k = 2
        val result = solution.kLengthApart(nums, k)
        assertEquals(true, result, "All 1s are at least 2 places apart")
    }

    @Test
    @DisplayName("Example 2: nums = [1,0,0,1,0,1], k = 2")
    fun testExample2() {
        val nums = intArrayOf(1, 0, 0, 1, 0, 1)
        val k = 2
        val result = solution.kLengthApart(nums, k)
        assertEquals(false, result, "Last two 1s are only 1 place apart")
    }

    @Test
    @DisplayName("Single 1 in array: nums = [1,0,0,0], k = 3")
    fun testSingleOne() {
        val nums = intArrayOf(1, 0, 0, 0)
        val k = 3
        val result = solution.kLengthApart(nums, k)
        assertEquals(true, result, "Single 1 should always return true")
    }

    @Test
    @DisplayName("No 1s in array: nums = [0,0,0,0], k = 2")
    fun testNoOnes() {
        val nums = intArrayOf(0, 0, 0, 0)
        val k = 2
        val result = solution.kLengthApart(nums, k)
        assertEquals(true, result, "No 1s should return true")
    }

    @Test
    @DisplayName("Two 1s exactly k places apart: nums = [1,0,0,1], k = 2")
    fun testExactlyKApart() {
        val nums = intArrayOf(1, 0, 0, 1)
        val k = 2
        val result = solution.kLengthApart(nums, k)
        assertEquals(true, result, "1s are exactly k places apart")
    }

    @Test
    @DisplayName("Two 1s less than k places apart: nums = [1,0,1], k = 2")
    fun testLessThanKApart() {
        val nums = intArrayOf(1, 0, 1)
        val k = 2
        val result = solution.kLengthApart(nums, k)
        assertEquals(false, result, "1s are only 1 place apart, need at least 2")
    }

    @Test
    @DisplayName("Two consecutive 1s with k = 0")
    fun testConsecutiveOnesWithKZero() {
        val nums = intArrayOf(1, 1, 1, 1)
        val k = 0
        val result = solution.kLengthApart(nums, k)
        assertEquals(true, result, "With k=0, consecutive 1s are valid")
    }

    @Test
    @DisplayName("Two consecutive 1s with k = 1")
    fun testConsecutiveOnesWithKOne() {
        val nums = intArrayOf(1, 1, 1, 1)
        val k = 1
        val result = solution.kLengthApart(nums, k)
        assertEquals(false, result, "Consecutive 1s violate k=1 requirement")
    }

    @Test
    @DisplayName("Multiple 1s with varying distances: nums = [1,0,0,0,1,0,1], k = 1")
    fun testMultipleOnesVaryingDistances() {
        val nums = intArrayOf(1, 0, 0, 0, 1, 0, 1)
        val k = 1
        val result = solution.kLengthApart(nums, k)
        assertEquals(true, result, "All 1s are at least 1 place apart")
    }

    @Test
    @DisplayName("Large distance between 1s: nums = [1,0,0,0,0,0,1], k = 3")
    fun testLargeDistance() {
        val nums = intArrayOf(1, 0, 0, 0, 0, 0, 1)
        val k = 3
        val result = solution.kLengthApart(nums, k)
        assertEquals(true, result, "1s are 5 places apart, more than k=3")
    }

    @Test
    @DisplayName("1s at start and end: nums = [1,0,0,0,1], k = 3")
    fun testOnesAtStartAndEnd() {
        val nums = intArrayOf(1, 0, 0, 0, 1)
        val k = 3
        val result = solution.kLengthApart(nums, k)
        assertEquals(true, result, "1s are exactly 3 places apart")
    }

    @Test
    @DisplayName("Fails on first pair: nums = [1,1,0,0,0,1], k = 2")
    fun testFailsOnFirstPair() {
        val nums = intArrayOf(1, 1, 0, 0, 0, 1)
        val k = 2
        val result = solution.kLengthApart(nums, k)
        assertEquals(false, result, "First two 1s are 0 places apart")
    }

    @Test
    @DisplayName("Fails on middle pair: nums = [1,0,0,1,1,0,0,1], k = 1")
    fun testFailsOnMiddlePair() {
        val nums = intArrayOf(1, 0, 0, 1, 1, 0, 0, 1)
        val k = 1
        val result = solution.kLengthApart(nums, k)
        assertEquals(false, result, "Middle 1s are 0 places apart")
    }

    @Test
    @DisplayName("Fails on last pair: nums = [1,0,0,1,0,0,1,1], k = 1")
    fun testFailsOnLastPair() {
        val nums = intArrayOf(1, 0, 0, 1, 0, 0, 1, 1)
        val k = 1
        val result = solution.kLengthApart(nums, k)
        assertEquals(false, result, "Last two 1s are 0 places apart")
    }
}
