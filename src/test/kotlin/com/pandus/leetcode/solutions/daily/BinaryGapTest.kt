package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BinaryGapTest {
    private val solution = BinaryGap()

    @Test
    @DisplayName("Example 1: n = 22, binary = '10110', output = 2")
    fun testExample1() {
        val result = solution.binaryGap(22)
        assertEquals(2, result, "22 in binary is '10110'. The largest distance between adjacent 1's is 2")
    }

    @Test
    @DisplayName("Example 2: n = 8, binary = '1000', output = 0")
    fun testExample2() {
        val result = solution.binaryGap(8)
        assertEquals(0, result, "8 in binary is '1000'. There are no adjacent pairs of 1's")
    }

    @Test
    @DisplayName("Example 3: n = 5, binary = '101', output = 2")
    fun testExample3() {
        val result = solution.binaryGap(5)
        assertEquals(2, result, "5 in binary is '101'. The distance between the two 1's is 2")
    }

    @Test
    @DisplayName("n = 1, binary = '1', output = 0")
    fun testSingleOne() {
        val result = solution.binaryGap(1)
        assertEquals(0, result, "Only one '1' in binary, no adjacent pairs")
    }

    @Test
    @DisplayName("n = 3, binary = '11', output = 1")
    fun testAdjacentOnes() {
        val result = solution.binaryGap(3)
        assertEquals(1, result, "3 in binary is '11'. The distance between adjacent 1's is 1")
    }

    @Test
    @DisplayName("n = 6, binary = '110', output = 1")
    fun testTwoAdjacentOnesAtStart() {
        val result = solution.binaryGap(6)
        assertEquals(1, result, "6 in binary is '110'. The distance between the two 1's is 1")
    }

    @Test
    @DisplayName("n = 9, binary = '1001', output = 3")
    fun testDistanceOfThree() {
        val result = solution.binaryGap(9)
        assertEquals(3, result, "9 in binary is '1001'. The distance between 1's is 3")
    }

    @Test
    @DisplayName("n = 13, binary = '1101', output = 2")
    fun testMultiplePairsWithDifferentDistances() {
        val result = solution.binaryGap(13)
        assertEquals(2, result, "13 in binary is '1101'. Maximum distance is 2")
    }

    @Test
    @DisplayName("n = 15, binary = '1111', output = 1")
    fun testAllOnes() {
        val result = solution.binaryGap(15)
        assertEquals(1, result, "15 in binary is '1111'. All distances are 1")
    }

    @Test
    @DisplayName("n = 32, binary = '100000', output = 0")
    fun testSingleOneAtHigherPosition() {
        val result = solution.binaryGap(32)
        assertEquals(0, result, "32 in binary is '100000'. Only one '1', no adjacent pairs")
    }

    @Test
    @DisplayName("n = 21, binary = '10101', output = 2")
    fun testAlternatingPattern() {
        val result = solution.binaryGap(21)
        assertEquals(2, result, "21 in binary is '10101'. All distances are 2")
    }

    @Test
    @DisplayName("n = 7, binary = '111', output = 1")
    fun testThreeConsecutiveOnes() {
        val result = solution.binaryGap(7)
        assertEquals(1, result, "7 in binary is '111'. All distances are 1")
    }

    @Test
    @DisplayName("n = 2, binary = '10', output = 0")
    fun testPowerOfTwo() {
        val result = solution.binaryGap(2)
        assertEquals(0, result, "2 in binary is '10'. Only one '1', no adjacent pairs")
    }

    @Test
    @DisplayName("n = 64, binary = '1000000', output = 0")
    fun testAnotherPowerOfTwo() {
        val result = solution.binaryGap(64)
        assertEquals(0, result, "64 in binary is '1000000'. Only one '1', no adjacent pairs")
    }

    @Test
    @DisplayName("n = 42, binary = '101010', output = 2")
    fun testAlternatingBits() {
        val result = solution.binaryGap(42)
        assertEquals(2, result, "42 in binary is '101010'. All distances are 2")
    }
}
