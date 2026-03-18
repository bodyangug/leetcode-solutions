package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountSubmatricesWithTopLeftElementAndSumLessThankTest {

    private val solution = CountSubmatricesWithTopLeftElementAndSumLessThank()

    @Test
    @DisplayName("Example 1: grid=[[7,6,3],[6,6,1]], k=18 -> 4")
    fun testExample1() {
        val grid = arrayOf(intArrayOf(7, 6, 3), intArrayOf(6, 6, 1))
        val result = solution.countSubmatrices(grid, 18)
        assertEquals(4, result)
    }

    @Test
    @DisplayName("Example 2: grid=[[7,2,9],[1,5,0],[2,6,6]], k=20 -> 6")
    fun testExample2() {
        val grid = arrayOf(intArrayOf(7, 2, 9), intArrayOf(1, 5, 0), intArrayOf(2, 6, 6))
        val result = solution.countSubmatrices(grid, 20)
        assertEquals(6, result)
    }

    @Test
    @DisplayName("Single element grid where element <= k")
    fun testSingleElementLessOrEqual() {
        val grid = arrayOf(intArrayOf(5))
        val result = solution.countSubmatrices(grid, 5)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Single element grid where element > k")
    fun testSingleElementGreater() {
        val grid = arrayOf(intArrayOf(10))
        val result = solution.countSubmatrices(grid, 5)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("All submatrices satisfy the condition")
    fun testAllSubmatricesSatisfy() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        val result = solution.countSubmatrices(grid, 100)
        assertEquals(4, result)
    }

    @Test
    @DisplayName("Only top-left element satisfies the condition")
    fun testOnlyTopLeft() {
        val grid = arrayOf(intArrayOf(5, 100), intArrayOf(100, 100))
        val result = solution.countSubmatrices(grid, 5)
        assertEquals(1, result)
    }

    @Test
    @DisplayName("Single row grid")
    fun testSingleRow() {
        val grid = arrayOf(intArrayOf(1, 2, 3, 4))
        val result = solution.countSubmatrices(grid, 6)
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Single column grid")
    fun testSingleColumn() {
        val grid = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3), intArrayOf(4))
        val result = solution.countSubmatrices(grid, 6)
        assertEquals(3, result)
    }

    @Test
    @DisplayName("k equals exact sum of full grid")
    fun testKEqualsFullGridSum() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val result = solution.countSubmatrices(grid, 10)
        assertEquals(4, result)
    }

    @Test
    @DisplayName("No submatrix satisfies when top-left > k")
    fun testTopLeftExceedsK() {
        val grid = arrayOf(intArrayOf(50, 1), intArrayOf(1, 1))
        val result = solution.countSubmatrices(grid, 10)
        assertEquals(0, result)
    }
}
