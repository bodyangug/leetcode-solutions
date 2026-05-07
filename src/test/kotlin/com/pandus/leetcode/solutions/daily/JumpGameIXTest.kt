package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JumpGameIXTest {
    private val solution = JumpGameIX()

    @Test
    @DisplayName("Example 1: [3,1,2] should return [3,3,3]")
    fun testExample1() {
        assertArrayEquals(intArrayOf(3, 3, 3), solution.maxValue(intArrayOf(3, 1, 2)))
    }

    @Test
    @DisplayName("Example 2: [1,2,3] strictly increasing should return [1,2,3]")
    fun testStrictlyIncreasing() {
        assertArrayEquals(intArrayOf(1, 2, 3), solution.maxValue(intArrayOf(1, 2, 3)))
    }

    @Test
    @DisplayName("Example 3: [3,2,1] strictly decreasing should return [3,3,3]")
    fun testStrictlyDecreasing() {
        assertArrayEquals(intArrayOf(3, 3, 3), solution.maxValue(intArrayOf(3, 2, 1)))
    }

    @Test
    @DisplayName("Single element: [5] should return [5]")
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(5), solution.maxValue(intArrayOf(5)))
    }

    @Test
    @DisplayName("Example: [1,3,2] should return [1,3,3]")
    fun testPeakInMiddle() {
        assertArrayEquals(intArrayOf(1, 3, 3), solution.maxValue(intArrayOf(1, 3, 2)))
    }

    @Test
    @DisplayName("Example: [1,4,2,5,3] should return [1,5,5,5,5]")
    fun testMixed() {
        assertArrayEquals(intArrayOf(1, 5, 5, 5, 5), solution.maxValue(intArrayOf(1, 4, 2, 5, 3)))
    }

    @Test
    @DisplayName("Equal elements: [2,2,2] should return [2,2,2]")
    fun testEqualElements() {
        assertArrayEquals(intArrayOf(2, 2, 2), solution.maxValue(intArrayOf(2, 2, 2)))
    }
}
