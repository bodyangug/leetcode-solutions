package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BinaryPrefixDivisibleBy5Test {
    private val solver = BinaryPrefixDivisibleBy5()

    @Test
    @DisplayName("Example 1: [0,1,1] -> [true,false,false]")
    fun prefixesDivBy5_example1() {
        val nums = intArrayOf(0, 1, 1)
        val expected = listOf(true, false, false)
        assertEquals(expected, solver.prefixesDivBy5(nums))
    }

    @Test
    @DisplayName("Example 2: [1,1,1] -> [false,false,false]")
    fun prefixesDivBy5_example2() {
        val nums = intArrayOf(1, 1, 1)
        val expected = listOf(false, false, false)
        assertEquals(expected, solver.prefixesDivBy5(nums))
    }

    @Test
    @DisplayName("Example 3: [0,1,1,1,1,1] -> [true,false,false,false,true,false]")
    fun prefixesDivBy5_example3() {
        val nums = intArrayOf(0, 1, 1, 1, 1, 1)
        val expected = listOf(true, false, false, false, true, false)
        assertEquals(expected, solver.prefixesDivBy5(nums))
    }

    @Test
    @DisplayName("Edge case: Single element [0] -> [true]")
    fun prefixesDivBy5_singleZero() {
        val nums = intArrayOf(0)
        val expected = listOf(true)
        assertEquals(expected, solver.prefixesDivBy5(nums))
    }

    @Test
    @DisplayName("Edge case: Single element [1] -> [false]")
    fun prefixesDivBy5_singleOne() {
        val nums = intArrayOf(1)
        val expected = listOf(false)
        assertEquals(expected, solver.prefixesDivBy5(nums))
    }

    @Test
    @DisplayName("Binary 101 (decimal 5): [1,0,1] -> [false,false,true]")
    fun prefixesDivBy5_binary101() {
        val nums = intArrayOf(1, 0, 1)
        val expected = listOf(false, false, true)
        assertEquals(expected, solver.prefixesDivBy5(nums))
    }

    @Test
    @DisplayName("Binary 1010 (decimal 10): [1,0,1,0] -> [false,false,true,true]")
    fun prefixesDivBy5_binary1010() {
        val nums = intArrayOf(1, 0, 1, 0)
        val expected = listOf(false, false, true, true)
        assertEquals(expected, solver.prefixesDivBy5(nums))
    }

    @Test
    @DisplayName("All zeros: [0,0,0,0] -> [true,true,true,true]")
    fun prefixesDivBy5_allZeros() {
        val nums = intArrayOf(0, 0, 0, 0)
        val expected = listOf(true, true, true, true)
        assertEquals(expected, solver.prefixesDivBy5(nums))
    }

    @Test
    @DisplayName("Large array test: verify modulo arithmetic handles overflow")
    fun prefixesDivBy5_largeArray() {
        // Creating a large array to test overflow handling
        val nums = intArrayOf(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0)
        val result = solver.prefixesDivBy5(nums)

        // Verify that result has same length as input
        assertEquals(nums.size, result.size)

        // Verify specific known values
        assertEquals(false, result[0]) // 1 % 5 = 1
        assertEquals(false, result[1]) // 11 (binary) = 3 % 5 = 3
        assertEquals(false, result[2]) // 111 (binary) = 7 % 5 = 2
    }

    @Test
    @DisplayName("Alternating pattern: [1,0,1,0]")
    fun prefixesDivBy5_alternating() {
        val nums = intArrayOf(1, 0, 1, 0)
        val result = solver.prefixesDivBy5(nums)

        // 1 (binary) = 1 -> false
        // 10 (binary) = 2 -> false
        // 101 (binary) = 5 -> true
        // 1010 (binary) = 10 -> true
        assertEquals(listOf(false, false, true, true), result)
    }

    @Test
    @DisplayName("Multiple of 5 in middle: [1,1,0,0,1]")
    fun prefixesDivBy5_multipleInMiddle() {
        val nums = intArrayOf(1, 1, 0, 0, 1)
        val result = solver.prefixesDivBy5(nums)

        // 1 (binary) = 1 -> false
        // 11 (binary) = 3 -> false
        // 110 (binary) = 6 -> false
        // 1100 (binary) = 12 -> false
        // 11001 (binary) = 25 -> true
        assertEquals(listOf(false, false, false, false, true), result)
    }
}
