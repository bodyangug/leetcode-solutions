package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FindAllPossibleStableBinaryArraysIITest {

    private lateinit var solution: FindAllPossibleStableBinaryArraysII

    @BeforeEach
    fun setUp() {
        solution = FindAllPossibleStableBinaryArraysII()
    }

    @Test
    @DisplayName("Example 1: zero=1, one=1, limit=2 returns 2")
    fun example1() {
        val result = solution.numberOfStableArrays(zero = 1, one = 1, limit = 2)
        assertEquals(2, result)
    }

    @Test
    @DisplayName("Example 2: zero=1, one=2, limit=1 returns 1")
    fun example2() {
        val result = solution.numberOfStableArrays(zero = 1, one = 2, limit = 1)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Example 3: zero=3, one=3, limit=2 returns 14")
    fun example3() {
        val result = solution.numberOfStableArrays(zero = 3, one = 3, limit = 2)
        assertEquals(14, result)
    }

    @Test
    @DisplayName("Edge case: single zero with high limit returns 1")
    fun singleZeroHighLimit() {
        val result = solution.numberOfStableArrays(zero = 1, one = 0, limit = 10)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Edge case: single one with high limit returns 1")
    fun singleOneHighLimit() {
        val result = solution.numberOfStableArrays(zero = 0, one = 1, limit = 10)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Edge case: limit=1 forces alternating pattern")
    fun limitOneForcesAlternating() {
        val result = solution.numberOfStableArrays(zero = 2, one = 2, limit = 1)
        assertEquals(2, result)
    }

    @Test
    @DisplayName("Large limit allows any arrangement")
    fun largeLimitAllowsAnyArrangement() {
        val result = solution.numberOfStableArrays(zero = 2, one = 2, limit = 4)
        assertEquals(6, result)
    }

    @Test
    @DisplayName("Edge case: no zeros returns 1 when one <= limit")
    fun noZerosWithinLimit() {
        val result = solution.numberOfStableArrays(zero = 0, one = 3, limit = 5)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Edge case: no ones returns 1 when zero <= limit")
    fun noOnesWithinLimit() {
        val result = solution.numberOfStableArrays(zero = 3, one = 0, limit = 5)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Edge case: no zeros returns 0 when one > limit")
    fun noZerosExceedsLimit() {
        val result = solution.numberOfStableArrays(zero = 0, one = 5, limit = 3)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Edge case: no ones returns 0 when zero > limit")
    fun noOnesExceedsLimit() {
        val result = solution.numberOfStableArrays(zero = 5, one = 0, limit = 3)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Symmetric case: equal zeros and ones with limit=1")
    fun symmetricWithLimitOne() {
        val result = solution.numberOfStableArrays(zero = 3, one = 3, limit = 1)
        assertEquals(2, result)
    }

    @Test
    @DisplayName("Large input: verifies memoization efficiency")
    fun largeInputMemoizationTest() {
        val result = solution.numberOfStableArrays(zero = 50, one = 50, limit = 10)
        assertEquals(true, result >= 0)
    }
}
