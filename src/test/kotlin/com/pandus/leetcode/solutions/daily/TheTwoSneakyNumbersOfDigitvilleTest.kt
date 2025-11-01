package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TheTwoSneakyNumbersOfDigitvilleTest {
    @Test
    @DisplayName("Returns two duplicate numbers in a small array")
    fun getSneakyNumbers_basic() {
        val solution = TheTwoSneakyNumbersOfDigitville()
        val result = solution.getSneakyNumbers(intArrayOf(0, 1, 1, 0))
        assertArrayEquals(intArrayOf(1, 0), result, "Should find both duplicate numbers")
    }

    @Test
    @DisplayName("Returns two duplicate numbers with larger values")
    fun getSneakyNumbers_largerValues() {
        val solution = TheTwoSneakyNumbersOfDigitville()
        val result = solution.getSneakyNumbers(intArrayOf(0, 3, 2, 1, 3, 2))
        assertArrayEquals(intArrayOf(3, 2), result, "Should find duplicates in order of first appearance")
    }

    @Test
    @DisplayName("Returns two duplicate numbers from a longer sequence")
    fun getSneakyNumbers_longerSequence() {
        val solution = TheTwoSneakyNumbersOfDigitville()
        val result = solution.getSneakyNumbers(intArrayOf(7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2))
        assertArrayEquals(intArrayOf(4, 5), result, "Should find the two sneaky numbers correctly")
    }
}
