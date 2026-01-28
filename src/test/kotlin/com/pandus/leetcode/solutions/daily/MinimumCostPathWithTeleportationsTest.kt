package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumCostPathWithTeleportationsTest {
    private val solution = MinimumCostPathWithTeleportations()

    @Test
    @DisplayName("Example 1: grid = [[1,3,3],[2,5,4],[4,3,5]], k = 2")
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(1, 3, 3),
            intArrayOf(2, 5, 4),
            intArrayOf(4, 3, 5)
        )
        val k = 2
        val result = solution.minCost(grid, k)
        assertEquals(7, result, "Minimum cost should be 7 with path: (0,0) -> (1,0) -> (1,1) -> teleport to (2,2)")
    }

    @Test
    @DisplayName("Example 2: grid = [[1,2],[2,3],[3,4]], k = 1")
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        val k = 1
        val result = solution.minCost(grid, k)
        assertEquals(9, result, "Minimum cost should be 9 with path: (0,0) -> (1,0) -> (1,1) -> (2,1)")
    }

    @Test
    @DisplayName("Single cell grid")
    fun testSingleCell() {
        val grid = arrayOf(
            intArrayOf(5)
        )
        val k = 0
        val result = solution.minCost(grid, k)
        assertEquals(0, result, "Already at destination, cost should be 0")
    }

    @Test
    @DisplayName("Grid with no teleportations allowed (k = 0)")
    fun testNoTeleportations() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val k = 0
        val result = solution.minCost(grid, k)
        assertEquals(6, result, "Without teleportations: (0,0) -> (0,1) -> (1,1) = 0 + 2 + 4 = 6")
    }

    @Test
    @DisplayName("Grid with unlimited teleportations")
    fun testUnlimitedTeleportations() {
        val grid = arrayOf(
            intArrayOf(5, 4, 3),
            intArrayOf(2, 1, 2),
            intArrayOf(3, 2, 1)
        )
        val k = 10
        val result = solution.minCost(grid, k)
        assertEquals(0, result, "With many teleportations, can reach destination at cost 0")
    }

    @Test
    @DisplayName("Linear grid (1 row)")
    fun testLinearRow() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4)
        )
        val k = 0
        val result = solution.minCost(grid, k)
        assertEquals(9, result, "Move right through all cells: 2 + 3 + 4 = 9")
    }

    @Test
    @DisplayName("Linear grid (1 column)")
    fun testLinearColumn() {
        val grid = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3),
            intArrayOf(4)
        )
        val k = 0
        val result = solution.minCost(grid, k)
        assertEquals(9, result, "Move down through all cells: 2 + 3 + 4 = 9")
    }

    @Test
    @DisplayName("Grid with all same values")
    fun testUniformGrid() {
        val grid = arrayOf(
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5)
        )
        val k = 1
        val result = solution.minCost(grid, k)
        assertEquals(0, result, "Can teleport to destination since all values are equal")
    }

    @Test
    @DisplayName("Grid with decreasing values - optimal for teleportation")
    fun testDecreasingValues() {
        val grid = arrayOf(
            intArrayOf(9, 8, 7),
            intArrayOf(6, 5, 4),
            intArrayOf(3, 2, 1)
        )
        val k = 2
        val result = solution.minCost(grid, k)
        assertEquals(0, result, "Can teleport directly to destination with decreasing values")
    }
}
