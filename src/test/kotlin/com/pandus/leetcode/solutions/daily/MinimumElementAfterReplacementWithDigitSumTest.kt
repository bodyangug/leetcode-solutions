package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumElementAfterReplacementWithDigitSumTest {
    @Test
    @DisplayName("Returns 1 for [10, 12, 13, 14]")
    fun minElement_example1() {
        val solution = MinimumElementAfterReplacementWithDigitSum()
        val result = solution.minElement(intArrayOf(10, 12, 13, 14))
        assertEquals(1, result, "Digit sum of 10 is 1, which is the minimum")
    }

    @Test
    @DisplayName("Returns 1 for [1, 2, 3, 4]")
    fun minElement_example2() {
        val solution = MinimumElementAfterReplacementWithDigitSum()
        val result = solution.minElement(intArrayOf(1, 2, 3, 4))
        assertEquals(1, result, "Digit sum of 1 is 1, which is the minimum")
    }

    @Test
    @DisplayName("Returns 10 for [999, 19, 199]")
    fun minElement_example3() {
        val solution = MinimumElementAfterReplacementWithDigitSum()
        val result = solution.minElement(intArrayOf(999, 19, 199))
        assertEquals(10, result, "Digit sum of 19 is 10, which is the minimum")
    }

    @Test
    @DisplayName("Returns 5 for single element array [5]")
    fun minElement_singleElement() {
        val solution = MinimumElementAfterReplacementWithDigitSum()
        val result = solution.minElement(intArrayOf(5))
        assertEquals(5, result, "Digit sum of 5 is 5")
    }

    @Test
    @DisplayName("Returns 1 for array with large numbers [111, 222, 333]")
    fun minElement_largeDigitSums() {
        val solution = MinimumElementAfterReplacementWithDigitSum()
        val result = solution.minElement(intArrayOf(111, 222, 333))
        assertEquals(3, result, "Digit sum of 111 is 3, which is the minimum")
    }

    @Test
    @DisplayName("Returns same value for all equal elements [55, 55, 55]")
    fun minElement_allEqual() {
        val solution = MinimumElementAfterReplacementWithDigitSum()
        val result = solution.minElement(intArrayOf(55, 55, 55))
        assertEquals(10, result, "Digit sum of 55 is 10 for all elements")
    }
}
