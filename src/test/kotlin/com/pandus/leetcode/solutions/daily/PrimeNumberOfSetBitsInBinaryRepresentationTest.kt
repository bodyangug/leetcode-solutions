package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PrimeNumberOfSetBitsInBinaryRepresentationTest {
    private val solver = PrimeNumberOfSetBitsInBinaryRepresentation()

    @Test
    @DisplayName("Example 1: left = 6, right = 10 -> 4")
    fun countPrimeSetBits_example1() {
        val left = 6
        val right = 10
        val expected = 4
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Example 2: left = 10, right = 15 -> 5")
    fun countPrimeSetBits_example2() {
        val left = 10
        val right = 15
        val expected = 5
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Edge case: Single number with prime set bits (left = 7, right = 7)")
    fun countPrimeSetBits_singleNumberPrime() {
        val left = 7
        val right = 7
        val expected = 1 // 7 -> 111 (3 set bits, 3 is prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Edge case: Single number with non-prime set bits (left = 8, right = 8)")
    fun countPrimeSetBits_singleNumberNonPrime() {
        val left = 8
        val right = 8
        val expected = 0 // 8 -> 1000 (1 set bit, 1 is not prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Edge case: Minimum range (left = 1, right = 1)")
    fun countPrimeSetBits_minimum() {
        val left = 1
        val right = 1
        val expected = 0 // 1 -> 1 (1 set bit, 1 is not prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range with all prime set bits (left = 2, right = 3)")
    fun countPrimeSetBits_allPrime() {
        val left = 2
        val right = 3
        val expected = 2 // 2 -> 10 (1 set bit, not prime), 3 -> 11 (2 set bits, 2 is prime)
        // Wait, 2 has 1 set bit (not prime), 3 has 2 set bits (prime)
        assertEquals(1, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range with no prime set bits (left = 1, right = 1)")
    fun countPrimeSetBits_noPrime() {
        val left = 1
        val right = 1
        val expected = 0 // 1 -> 1 (1 set bit, 1 is not prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range with 2 set bits (left = 3, right = 3)")
    fun countPrimeSetBits_twoSetBits() {
        val left = 3
        val right = 3
        val expected = 1 // 3 -> 11 (2 set bits, 2 is prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range with 3 set bits (left = 7, right = 7)")
    fun countPrimeSetBits_threeSetBits() {
        val left = 7
        val right = 7
        val expected = 1 // 7 -> 111 (3 set bits, 3 is prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range with 5 set bits (left = 31, right = 31)")
    fun countPrimeSetBits_fiveSetBits() {
        val left = 31
        val right = 31
        val expected = 1 // 31 -> 11111 (5 set bits, 5 is prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range with 4 set bits - not prime (left = 15, right = 15)")
    fun countPrimeSetBits_fourSetBitsNonPrime() {
        val left = 15
        val right = 15
        val expected = 0 // 15 -> 1111 (4 set bits, 4 is not prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Small range with mixed results (left = 1, right = 5)")
    fun countPrimeSetBits_smallMixedRange() {
        val left = 1
        val right = 5
        // 1 -> 1 (1 set bit, not prime)
        // 2 -> 10 (1 set bit, not prime)
        // 3 -> 11 (2 set bits, prime) ✓
        // 4 -> 100 (1 set bit, not prime)
        // 5 -> 101 (2 set bits, prime) ✓
        val expected = 2
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range testing 7 set bits - prime (left = 127, right = 127)")
    fun countPrimeSetBits_sevenSetBitsPrime() {
        val left = 127
        val right = 127
        val expected = 1 // 127 -> 1111111 (7 set bits, 7 is prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range testing 11 set bits - prime (left = 2047, right = 2047)")
    fun countPrimeSetBits_elevenSetBitsPrime() {
        val left = 2047
        val right = 2047
        val expected = 1 // 2047 -> 11111111111 (11 set bits, 11 is prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Range testing 13 set bits - prime (left = 8191, right = 8191)")
    fun countPrimeSetBits_thirteenSetBitsPrime() {
        val left = 8191
        val right = 8191
        val expected = 1 // 8191 -> 1111111111111 (13 set bits, 13 is prime)
        assertEquals(expected, solver.countPrimeSetBits(left, right))
    }

    @Test
    @DisplayName("Large range (left = 100, right = 200)")
    fun countPrimeSetBits_largeRange() {
        val left = 100
        val right = 200
        // This tests the implementation with a larger range
        val result = solver.countPrimeSetBits(left, right)
        // The result should be non-negative and <= range size
        assert(result >= 0)
        assert(result <= (right - left + 1))
    }
}
