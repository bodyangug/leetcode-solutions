package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumSquareAreaByRemovingFencesFromFieldTest {
    private val solution = MaximumSquareAreaByRemovingFencesFromField()

    @Test
    @DisplayName("Example 1: Basic case with square of area 4")
    fun testExample1() {
        val m = 4
        val n = 3
        val hFences = intArrayOf(2, 3)
        val vFences = intArrayOf(2)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        assertEquals(4, result, "Should return 4 for square with side length 2")
    }

    @Test
    @DisplayName("Example 2: No square possible")
    fun testExample2() {
        val m = 6
        val n = 7
        val hFences = intArrayOf(2)
        val vFences = intArrayOf(4)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        assertEquals(-1, result, "Should return -1 when no square is possible")
    }

    @Test
    @DisplayName("No fences - full field dimensions")
    fun testNoFences() {
        val m = 5
        val n = 5
        val hFences = intArrayOf()
        val vFences = intArrayOf()
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        assertEquals(16, result, "Should return 16 for 4x4 square (full field)")
    }

    @Test
    @DisplayName("Minimum field size 2x2")
    fun testMinimumFieldSize() {
        val m = 2
        val n = 2
        val hFences = intArrayOf()
        val vFences = intArrayOf()
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        assertEquals(1, result, "Should return 1 for 1x1 square")
    }

    @Test
    @DisplayName("Large square with multiple fences")
    fun testLargeSquareWithMultipleFences() {
        val m = 10
        val n = 10
        val hFences = intArrayOf(3, 5, 7)
        val vFences = intArrayOf(3, 5, 7)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        // Maximum common edge: 9 (10-1 or other combinations)
        assertEquals(81, result, "Should return 81 for 9x9 square")
    }

    @Test
    @DisplayName("Non-square field dimensions")
    fun testNonSquareField() {
        val m = 8
        val n = 4
        val hFences = intArrayOf(5)
        val vFences = intArrayOf(2)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        // Common edge of 3 (from vertical: 4-1=3, from horizontal: multiple options)
        assertEquals(9, result, "Should return 9 for 3x3 square")
    }

    @Test
    @DisplayName("Multiple common edges - return maximum")
    fun testMultipleCommonEdges() {
        val m = 7
        val n = 7
        val hFences = intArrayOf(2, 4, 5)
        val vFences = intArrayOf(2, 4, 5)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        // Maximum common edge should be 6 (7-1)
        assertEquals(36, result, "Should return 36 for 6x6 square")
    }

    @Test
    @DisplayName("Large modulo result")
    fun testLargeModuloResult() {
        val m = 100000
        val n = 100000
        val hFences = intArrayOf()
        val vFences = intArrayOf()
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        val expected = (99999L * 99999L % 1000000007).toInt()
        assertEquals(expected, result, "Should apply modulo 1000000007 correctly")
    }

    @Test
    @DisplayName("Only horizontal fences match")
    fun testOnlyHorizontalFencesWithCommonEdge() {
        val m = 6
        val n = 4
        val hFences = intArrayOf(3, 5)
        val vFences = intArrayOf(2)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        // Check for common edge of 3 (vertical: 4-1=3, horizontal: 5-2=3 or 3-1=2)
        assertEquals(9, result, "Should return 9 for 3x3 square")
    }

    @Test
    @DisplayName("Fences at boundaries")
    fun testFencesAtBoundaries() {
        val m = 5
        val n = 5
        val hFences = intArrayOf(2, 3, 4)
        val vFences = intArrayOf(2, 3, 4)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        // Maximum common edge should be 4 (5-1)
        assertEquals(16, result, "Should return 16 for 4x4 square")
    }

    @Test
    @DisplayName("Small field with no common edges")
    fun testSmallFieldNoCommonEdges() {
        val m = 3
        val n = 4
        val hFences = intArrayOf(2)
        val vFences = intArrayOf(3)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        // Horizontal edges: 1, 2; Vertical edges: 1, 2, 3
        // Common: 1, 2
        assertEquals(4, result, "Should return 4 for 2x2 square")
    }

    @Test
    @DisplayName("Dense fences creating many small segments")
    fun testDenseFences() {
        val m = 6
        val n = 6
        val hFences = intArrayOf(2, 3, 4, 5)
        val vFences = intArrayOf(2, 3, 4, 5)
        val result = solution.maximizeSquareArea(m, n, hFences, vFences)
        // Maximum common edge should be 5 (6-1)
        assertEquals(25, result, "Should return 25 for 5x5 square")
    }
}
