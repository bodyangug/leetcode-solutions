package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumCostPathWithEdgeReversalsTest {
    private val solution = MinimumCostPathWithEdgeReversals()

    @Test
    @DisplayName("Example 1: n = 4, edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]")
    fun testExample1() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(0, 1, 3),
            intArrayOf(3, 1, 1),
            intArrayOf(2, 3, 4),
            intArrayOf(0, 2, 2)
        )
        val result = solution.minCost(n, edges)
        assertEquals(5, result, "Path 0 → 1 (cost 3), reverse 3 → 1 to 1 → 3 (cost 2*1=2). Total: 3 + 2 = 5")
    }

    @Test
    @DisplayName("Example 2: n = 4, edges = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]")
    fun testExample2() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(0, 2, 1),
            intArrayOf(2, 1, 1),
            intArrayOf(1, 3, 1),
            intArrayOf(2, 3, 3)
        )
        val result = solution.minCost(n, edges)
        assertEquals(3, result, "No reversal needed. Path: 0 → 2 (cost 1), 2 → 1 (cost 1), 1 → 3 (cost 1). Total: 3")
    }

    @Test
    @DisplayName("Single edge direct path")
    fun testSingleEdgeDirectPath() {
        val n = 2
        val edges = arrayOf(
            intArrayOf(0, 1, 5)
        )
        val result = solution.minCost(n, edges)
        assertEquals(5, result, "Direct path from 0 to 1 with cost 5")
    }

    @Test
    @DisplayName("No path exists")
    fun testNoPathExists() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 0, 3)
        )
        val result = solution.minCost(n, edges)
        assertEquals(-1, result, "No path exists from node 0 to node 2")
    }

    @Test
    @DisplayName("Already at destination")
    fun testAlreadyAtDestination() {
        val n = 1
        val edges = arrayOf<IntArray>()
        val result = solution.minCost(n, edges)
        assertEquals(0, result, "Already at destination (node 0 is also node n-1)")
    }

    @Test
    @DisplayName("Multiple paths - choose optimal")
    fun testMultiplePathsChooseOptimal() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 10),
            intArrayOf(1, 2, 10),
            intArrayOf(0, 2, 15)
        )
        val result = solution.minCost(n, edges)
        assertEquals(15, result, "Direct path 0 → 2 (cost 15) is better than 0 → 1 → 2 (cost 20)")
    }

    @Test
    @DisplayName("Reverse edge is optimal")
    fun testReverseEdgeIsOptimal() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(2, 1, 1)
        )
        val result = solution.minCost(n, edges)
        assertEquals(3, result, "Path: 0 → 1 (cost 1), reverse 2 → 1 to 1 → 2 (cost 2*1=2). Total: 3")
    }

    @Test
    @DisplayName("Complex graph with multiple reversals available")
    fun testComplexGraphWithMultipleReversals() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 3),
            intArrayOf(3, 2, 1),
            intArrayOf(2, 4, 4)
        )
        val result = solution.minCost(n, edges)
        assertEquals(9, result, "Optimal path through the complex graph")
    }

    @Test
    @DisplayName("Linear path without reversals")
    fun testLinearPathWithoutReversals() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(2, 3, 3),
            intArrayOf(3, 4, 4)
        )
        val result = solution.minCost(n, edges)
        assertEquals(10, result, "Linear path: 0 → 1 → 2 → 3 → 4 with costs 1+2+3+4=10")
    }

    @Test
    @DisplayName("All edges reversed - high cost")
    fun testAllEdgesReversed() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(2, 1, 1)
        )
        val result = solution.minCost(n, edges)
        assertEquals(4, result, "Reverse 1 → 0 to 0 → 1 (cost 2), reverse 2 → 1 to 1 → 2 (cost 2). Total: 4")
    }

    @Test
    @DisplayName("Two nodes with bidirectional edges")
    fun testBidirectionalEdges() {
        val n = 2
        val edges = arrayOf(
            intArrayOf(0, 1, 3),
            intArrayOf(1, 0, 2)
        )
        val result = solution.minCost(n, edges)
        assertEquals(3, result, "Direct edge 0 → 1 costs 3, which is better than reversing 1 → 0 (cost 4)")
    }

    @Test
    @DisplayName("Large cost values")
    fun testLargeCostValues() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 1000),
            intArrayOf(1, 2, 2000)
        )
        val result = solution.minCost(n, edges)
        assertEquals(3000, result, "Handle large cost values correctly: 1000 + 2000 = 3000")
    }

    @Test
    @DisplayName("Multiple paths with different costs")
    fun testMultiplePathsDifferentCosts() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(0, 2, 10),
            intArrayOf(1, 3, 1),
            intArrayOf(2, 3, 1)
        )
        val result = solution.minCost(n, edges)
        assertEquals(2, result, "Choose path 0 → 1 → 3 (cost 2) over 0 → 2 → 3 (cost 11)")
    }

    @Test
    @DisplayName("Star graph from center")
    fun testStarGraphFromCenter() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0, 1, 5),
            intArrayOf(0, 2, 3),
            intArrayOf(0, 3, 7),
            intArrayOf(0, 4, 2)
        )
        val result = solution.minCost(n, edges)
        assertEquals(2, result, "Direct path from center to node 4 with cost 2")
    }

    @Test
    @DisplayName("Diamond graph structure")
    fun testDiamondGraph() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(0, 2, 1),
            intArrayOf(1, 3, 10),
            intArrayOf(2, 3, 2)
        )
        val result = solution.minCost(n, edges)
        assertEquals(3, result, "Path 0 → 2 → 3 with cost 1+2=3 is optimal")
    }
}
