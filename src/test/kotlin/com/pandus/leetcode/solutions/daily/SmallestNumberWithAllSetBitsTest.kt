package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SmallestNumberWithAllSetBitsTest {
    @Test
    @DisplayName("Returns 1 for input 1")
    fun smallestNumber_basic1() {
        val solution = SmallestNumberWithAllSetBits()
        val result = solution.smallestNumber(1)
        assertEquals(1, result, "For n=1, the smallest number with all set bits should be 1 (binary: 1)")
    }

    @Test
    @DisplayName("Returns 7 for input 5")
    fun smallestNumber_basic2() {
        val solution = SmallestNumberWithAllSetBits()
        val result = solution.smallestNumber(5)
        assertEquals(7, result, "For n=5, the smallest number with all set bits should be 7 (binary: 111)")
    }

    @Test
    @DisplayName("Returns 15 for input 10")
    fun smallestNumber_basic3() {
        val solution = SmallestNumberWithAllSetBits()
        val result = solution.smallestNumber(10)
        assertEquals(15, result, "For n=10, the smallest number with all set bits should be 15 (binary: 1111)")
    }
}
