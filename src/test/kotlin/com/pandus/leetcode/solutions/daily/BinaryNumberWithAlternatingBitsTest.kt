package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BinaryNumberWithAlternatingBitsTest {
    private val solver = BinaryNumberWithAlternatingBits()

    @Test
    @DisplayName("Example 1: n = 5 (binary: 101) -> true")
    fun hasAlternatingBits_example1() {
        val n = 5
        val expected = true
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("Example 2: n = 7 (binary: 111) -> false")
    fun hasAlternatingBits_example2() {
        val n = 7
        val expected = false
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("Example 3: n = 11 (binary: 1011) -> false")
    fun hasAlternatingBits_example3() {
        val n = 11
        val expected = false
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("Edge case: n = 1 (binary: 1) -> true")
    fun hasAlternatingBits_singleBit() {
        val n = 1
        val expected = true
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("Edge case: n = 2 (binary: 10) -> true")
    fun hasAlternatingBits_twoBits() {
        val n = 2
        val expected = true
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("Edge case: n = 3 (binary: 11) -> false")
    fun hasAlternatingBits_consecutiveOnes() {
        val n = 3
        val expected = false
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("n = 10 (binary: 1010) -> true")
    fun hasAlternatingBits_fourBitsAlternating() {
        val n = 10
        val expected = true
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("n = 4 (binary: 100) -> false")
    fun hasAlternatingBits_consecutiveZeros() {
        val n = 4
        val expected = false
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("n = 21 (binary: 10101) -> true")
    fun hasAlternatingBits_fiveBitsAlternating() {
        val n = 21
        val expected = true
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("n = 42 (binary: 101010) -> true")
    fun hasAlternatingBits_sixBitsAlternating() {
        val n = 42
        val expected = true
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("n = 85 (binary: 1010101) -> true")
    fun hasAlternatingBits_sevenBitsAlternating() {
        val n = 85
        val expected = true
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("n = 170 (binary: 10101010) -> true")
    fun hasAlternatingBits_eightBitsAlternating() {
        val n = 170
        val expected = true
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("n = 8 (binary: 1000) -> false")
    fun hasAlternatingBits_multipleConsecutiveZeros() {
        val n = 8
        val expected = false
        assertEquals(expected, solver.hasAlternatingBits(n))
    }

    @Test
    @DisplayName("n = 15 (binary: 1111) -> false")
    fun hasAlternatingBits_allOnes() {
        val n = 15
        val expected = false
        assertEquals(expected, solver.hasAlternatingBits(n))
    }
}
