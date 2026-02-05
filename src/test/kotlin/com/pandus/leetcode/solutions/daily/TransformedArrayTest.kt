package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TransformedArrayTest {
    @Test
    @DisplayName("Example 1: Mixed positive and negative values with wrapping")
    fun constructTransformedArray_example1() {
        val solution = TransformedArray()
        val result = solution.constructTransformedArray(intArrayOf(3, -2, 1, 1))
        assertArrayEquals(intArrayOf(1, 1, 1, 3), result, "Should correctly transform array with wrapping")
    }

    @Test
    @DisplayName("Example 2: Array with negative and positive values")
    fun constructTransformedArray_example2() {
        val solution = TransformedArray()
        val result = solution.constructTransformedArray(intArrayOf(-1, 4, -1))
        assertArrayEquals(intArrayOf(-1, -1, 4), result, "Should handle negative movements and wrap around")
    }

    @Test
    @DisplayName("Array with all zeros")
    fun constructTransformedArray_allZeros() {
        val solution = TransformedArray()
        val result = solution.constructTransformedArray(intArrayOf(0, 0, 0, 0))
        assertArrayEquals(intArrayOf(0, 0, 0, 0), result, "Array with all zeros should return itself")
    }

    @Test
    @DisplayName("Single element array")
    fun constructTransformedArray_singleElement() {
        val solution = TransformedArray()
        val result = solution.constructTransformedArray(intArrayOf(5))
        assertArrayEquals(intArrayOf(5), result, "Single element should point to itself")
    }

    @Test
    @DisplayName("Array where each element points to the next")
    fun constructTransformedArray_sequential() {
        val solution = TransformedArray()
        val result = solution.constructTransformedArray(intArrayOf(1, 1, 1, 1))
        assertArrayEquals(intArrayOf(1, 1, 1, 1), result, "Sequential movements should cycle correctly")
    }

    @Test
    @DisplayName("Array with exact wraparound to same position")
    fun constructTransformedArray_exactWrap() {
        val solution = TransformedArray()
        val result = solution.constructTransformedArray(intArrayOf(4, 1, 2, 3))
        assertArrayEquals(intArrayOf(4, 2, 4, 2), result, "Element moving by array length should stay in place")
    }

    @Test
    @DisplayName("Two element array with positive values")
    fun constructTransformedArray_twoElements() {
        val solution = TransformedArray()
        val result = solution.constructTransformedArray(intArrayOf(1, 1))
        assertArrayEquals(intArrayOf(1, 1), result, "Two element array should swap correctly")
    }
}
