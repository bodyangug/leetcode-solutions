package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FourDivisorsTest {
    private val solver = FourDivisors()

    @Test
    @DisplayName("Example 1: [21,4,7] -> 32")
    fun sumFourDivisors_example1() {
        val nums = intArrayOf(21, 4, 7)
        val expected = 32
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Example 2: [21,21] -> 64")
    fun sumFourDivisors_example2() {
        val nums = intArrayOf(21, 21)
        val expected = 64
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Example 3: [1,2,3,4,5] -> 0")
    fun sumFourDivisors_example3() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val expected = 0
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Edge case: Empty array -> 0")
    fun sumFourDivisors_emptyArray() {
        val nums = intArrayOf()
        val expected = 0
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Edge case: Single element with 4 divisors [6] -> 12")
    fun sumFourDivisors_singleElementWithFourDivisors() {
        // 6 has divisors: 1, 2, 3, 6 (exactly 4 divisors)
        val nums = intArrayOf(6)
        val expected = 12 // 1 + 2 + 3 + 6
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Edge case: Single element without 4 divisors [9] -> 0")
    fun sumFourDivisors_singleElementWithoutFourDivisors() {
        // 9 has divisors: 1, 3, 9 (only 3 divisors)
        val nums = intArrayOf(9)
        val expected = 0
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Number with exactly 4 divisors [8] -> 15")
    fun sumFourDivisors_eightHasFourDivisors() {
        // 8 has divisors: 1, 2, 4, 8 (exactly 4 divisors)
        val nums = intArrayOf(8)
        val expected = 15 // 1 + 2 + 4 + 8
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Number with exactly 4 divisors [10] -> 18")
    fun sumFourDivisors_tenHasFourDivisors() {
        // 10 has divisors: 1, 2, 5, 10 (exactly 4 divisors)
        val nums = intArrayOf(10)
        val expected = 18 // 1 + 2 + 5 + 10
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Prime number [7] -> 0")
    fun sumFourDivisors_primeNumber() {
        // 7 has divisors: 1, 7 (only 2 divisors)
        val nums = intArrayOf(7)
        val expected = 0
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Perfect square [16] -> 0")
    fun sumFourDivisors_perfectSquare() {
        // 16 has divisors: 1, 2, 4, 8, 16 (5 divisors, not 4)
        val nums = intArrayOf(16)
        val expected = 0
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Multiple numbers with mixed divisor counts [6,8,10] -> 45")
    fun sumFourDivisors_multipleNumbersWithFourDivisors() {
        // 6: 1, 2, 3, 6 -> sum = 12
        // 8: 1, 2, 4, 8 -> sum = 15
        // 10: 1, 2, 5, 10 -> sum = 18
        // Total: 12 + 15 + 18 = 45
        val nums = intArrayOf(6, 8, 10)
        val expected = 45
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Mix of numbers with and without 4 divisors [6,9,10] -> 30")
    fun sumFourDivisors_mixedNumbers() {
        // 6: 1, 2, 3, 6 -> sum = 12
        // 9: 1, 3, 9 -> 3 divisors, skip
        // 10: 1, 2, 5, 10 -> sum = 18
        // Total: 12 + 18 = 30
        val nums = intArrayOf(6, 9, 10)
        val expected = 30
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Large number with 4 divisors [15] -> 24")
    fun sumFourDivisors_largeNumberWithFourDivisors() {
        // 15 has divisors: 1, 3, 5, 15 (exactly 4 divisors)
        val nums = intArrayOf(15)
        val expected = 24 // 1 + 3 + 5 + 15
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Number 1 has only 1 divisor -> 0")
    fun sumFourDivisors_one() {
        // 1 has divisors: 1 (only 1 divisor)
        val nums = intArrayOf(1)
        val expected = 0
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Duplicate numbers [6,6] -> 24")
    fun sumFourDivisors_duplicates() {
        // 6: 1, 2, 3, 6 -> sum = 12
        // 6: 1, 2, 3, 6 -> sum = 12
        // Total: 12 + 12 = 24
        val nums = intArrayOf(6, 6)
        val expected = 24
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Product of two primes [14] -> 24")
    fun sumFourDivisors_productOfTwoPrimes() {
        // 14 = 2 * 7 has divisors: 1, 2, 7, 14 (exactly 4 divisors)
        val nums = intArrayOf(14)
        val expected = 24 // 1 + 2 + 7 + 14
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Cube of prime [27] -> 0")
    fun sumFourDivisors_cubeOfPrime() {
        // 27 = 3^3 has divisors: 1, 3, 9, 27 (exactly 4 divisors)
        val nums = intArrayOf(27)
        val expected = 40 // 1 + 3 + 9 + 27
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Highly composite number [12] -> 0")
    fun sumFourDivisors_highlyCompositeNumber() {
        // 12 has divisors: 1, 2, 3, 4, 6, 12 (6 divisors, not 4)
        val nums = intArrayOf(12)
        val expected = 0
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Power of 2 that has 4 divisors [8] -> 15")
    fun sumFourDivisors_powerOfTwo() {
        // 8 = 2^3 has divisors: 1, 2, 4, 8 (exactly 4 divisors)
        val nums = intArrayOf(8)
        val expected = 15 // 1 + 2 + 4 + 8
        assertEquals(expected, solver.sumFourDivisors(nums))
    }

    @Test
    @DisplayName("Large array with mixed cases")
    fun sumFourDivisors_largeArrayMixedCases() {
        // 21: 1, 3, 7, 21 -> sum = 32
        // 4: 1, 2, 4 -> 3 divisors, skip
        // 7: 1, 7 -> 2 divisors, skip
        // 6: 1, 2, 3, 6 -> sum = 12
        // 8: 1, 2, 4, 8 -> sum = 15
        // Total: 32 + 12 + 15 = 59
        val nums = intArrayOf(21, 4, 7, 6, 8)
        val expected = 59
        assertEquals(expected, solver.sumFourDivisors(nums))
    }
}
