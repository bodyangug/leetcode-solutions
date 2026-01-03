package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NumberOfWaysToPaintN3GridTest {
    private val solution = NumberOfWaysToPaintN3Grid()

    @Test
    @DisplayName("Example 1: n = 1")
    fun testExample1() {
        val n = 1
        val result = solution.numOfWays(n)
        assertEquals(12, result, "For a 1x3 grid, there are 12 possible ways to paint")
    }

    @Test
    @DisplayName("Example 2: n = 5000")
    fun testExample2() {
        val n = 5000
        val result = solution.numOfWays(n)
        assertEquals(30228214, result, "For a 5000x3 grid, the result should be 30228214")
    }

    @Test
    @DisplayName("n = 2")
    fun testTwoRows() {
        val n = 2
        val result = solution.numOfWays(n)
        assertEquals(54, result, "For a 2x3 grid, there are 54 possible ways to paint")
    }

    @Test
    @DisplayName("n = 3")
    fun testThreeRows() {
        val n = 3
        val result = solution.numOfWays(n)
        assertEquals(246, result, "For a 3x3 grid, there are 246 possible ways to paint")
    }

    @Test
    @DisplayName("n = 4")
    fun testFourRows() {
        val n = 4
        val result = solution.numOfWays(n)
        assertEquals(1122, result, "For a 4x3 grid, there are 1122 possible ways to paint")
    }

    @Test
    @DisplayName("n = 5")
    fun testFiveRows() {
        val n = 5
        val result = solution.numOfWays(n)
        assertEquals(5118, result, "For a 5x3 grid, there are 5118 possible ways to paint")
    }

    @Test
    @DisplayName("n = 10")
    fun testTenRows() {
        val n = 10
        val result = solution.numOfWays(n)
        assertEquals(10107954, result, "For a 10x3 grid, the result should be 10107954")
    }

    @Test
    @DisplayName("n = 100")
    fun testHundredRows() {
        val n = 100
        val result = solution.numOfWays(n)
        assertEquals(905790447, result, "For a 100x3 grid, the result should be 905790447")
    }

    @Test
    @DisplayName("n = 1000")
    fun testThousandRows() {
        val n = 1000
        val result = solution.numOfWays(n)
        assertEquals(650420578, result, "For a 1000x3 grid, the result should be 650420578")
    }

    @Test
    @DisplayName("Edge case: Large value n = 4999")
    fun testLargeValueJustBelow5000() {
        val n = 4999
        val result = solution.numOfWays(n)
        assertEquals(134620719, result, "For a 4999x3 grid, the result should be properly calculated with modulo")
    }

    @Test
    @DisplayName("Edge case: n = 5001 (just above 5000)")
    fun testLargeValueJustAbove5000() {
        val n = 5001
        val result = solution.numOfWays(n)
        assertEquals(881899639, result, "For a 5001x3 grid, the result should be properly calculated with modulo")
    }
}
