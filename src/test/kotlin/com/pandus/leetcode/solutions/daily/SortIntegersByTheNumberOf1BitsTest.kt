package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SortIntegersByTheNumberOf1BitsTest {
    private val solution = SortIntegersByTheNumberOf1Bits()

    @Test
    @DisplayName("Example 1: arr = [0,1,2,3,4,5,6,7,8], output = [0,1,2,4,8,3,5,6,7]")
    fun testExample1() {
        val input = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
        val expected = intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "[0] has 0 bits, [1,2,4,8] have 1 bit, [3,5,6] have 2 bits, [7] has 3 bits")
    }

    @Test
    @DisplayName("Example 2: arr = [1024,512,256,128,64,32,16,8,4,2,1], output = [1,2,4,8,16,32,64,128,256,512,1024]")
    fun testExample2() {
        val input = intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1)
        val expected = intArrayOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "All integers have 1 bit, sorted in ascending order")
    }

    @Test
    @DisplayName("Single element array: arr = [5], output = [5]")
    fun testSingleElement() {
        val input = intArrayOf(5)
        val expected = intArrayOf(5)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "Single element array should remain unchanged")
    }

    @Test
    @DisplayName("Array with zeros: arr = [0,0,0], output = [0,0,0]")
    fun testAllZeros() {
        val input = intArrayOf(0, 0, 0)
        val expected = intArrayOf(0, 0, 0)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "All zeros have 0 bits")
    }

    @Test
    @DisplayName("Array with same bit count: arr = [3,5,6], output = [3,5,6]")
    fun testSameBitCount() {
        val input = intArrayOf(3, 5, 6)
        val expected = intArrayOf(3, 5, 6)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "All have 2 bits, sorted by value: 3(11), 5(101), 6(110)")
    }

    @Test
    @DisplayName("Array with duplicates: arr = [2,3,2,4,5,4], output = [2,2,4,4,3,5]")
    fun testWithDuplicates() {
        val input = intArrayOf(2, 3, 2, 4, 5, 4)
        val expected = intArrayOf(2, 2, 4, 4, 3, 5)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "[2,2,4,4] have 1 bit, [3,5] have 2 bits")
    }

    @Test
    @DisplayName("Already sorted by bits: arr = [1,2,3], output = [1,2,3]")
    fun testAlreadySorted() {
        val input = intArrayOf(1, 2, 3)
        val expected = intArrayOf(1, 2, 3)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "1(1) has 1 bit, 2(10) has 1 bit, 3(11) has 2 bits")
    }

    @Test
    @DisplayName("Reverse sorted: arr = [8,7,6,5,4,3,2,1,0], output = [0,1,2,4,8,3,5,6,7]")
    fun testReverseSorted() {
        val input = intArrayOf(8, 7, 6, 5, 4, 3, 2, 1, 0)
        val expected = intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "Reverse sorted should be properly sorted by bit count")
    }

    @Test
    @DisplayName("Large numbers: arr = [10000,10000-1,10000-2], output sorted by bits")
    fun testLargeNumbers() {
        val input = intArrayOf(10000, 9999, 9998)
        val result = solution.sortByBits(input)
        // 10000 = 10011100010000 (5 bits)
        // 9999 = 10011100001111 (8 bits)
        // 9998 = 10011100001110 (7 bits)
        val expected = intArrayOf(10000, 9998, 9999)
        assertArrayEquals(expected, result, "10000 has 5 bits, 9998 has 7 bits, 9999 has 8 bits")
    }

    @Test
    @DisplayName("Mixed numbers: arr = [7,15,31,63], output = [7,15,31,63]")
    fun testAllOnes() {
        val input = intArrayOf(7, 15, 31, 63)
        val expected = intArrayOf(7, 15, 31, 63)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "7(111)=3 bits, 15(1111)=4 bits, 31(11111)=5 bits, 63(111111)=6 bits")
    }

    @Test
    @DisplayName("Random order with various bit counts: arr = [10,100,1000,10000]")
    fun testPowersOfTen() {
        val input = intArrayOf(10, 100, 1000, 10000)
        val result = solution.sortByBits(input)
        // 10 = 1010 (2 bits)
        // 100 = 1100100 (3 bits)
        // 1000 = 1111101000 (6 bits)
        // 10000 = 10011100010000 (5 bits)
        val expected = intArrayOf(10, 100, 10000, 1000)
        assertArrayEquals(expected, result, "Sorted by bit count: 10(2), 100(3), 10000(5), 1000(6)")
    }

    @Test
    @DisplayName("Two elements: arr = [15,7], output = [7,15]")
    fun testTwoElements() {
        val input = intArrayOf(15, 7)
        val expected = intArrayOf(7, 15)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "Both have 3 bits (111) and (1111), sorted by value")
    }

    @Test
    @DisplayName("Edge case with 0 and powers of 2: arr = [0,1,2,4,8,16], output = [0,1,2,4,8,16]")
    fun testZeroAndPowersOfTwo() {
        val input = intArrayOf(0, 1, 2, 4, 8, 16)
        val expected = intArrayOf(0, 1, 2, 4, 8, 16)
        val result = solution.sortByBits(input)
        assertArrayEquals(expected, result, "0 has 0 bits, all powers of 2 have 1 bit each")
    }
}
