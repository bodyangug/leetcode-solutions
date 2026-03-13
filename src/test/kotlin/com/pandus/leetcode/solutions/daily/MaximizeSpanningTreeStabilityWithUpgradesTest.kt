package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximizeSpanningTreeStabilityWithUpgradesTest {
    private val solution = MaximizeSpanningTreeStabilityWithUpgrades()

    @Test
    @DisplayName("Example 1: n=3, one must edge + one optional edge with 1 upgrade - should return 2")
    fun testExample1() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 2, 1),
            intArrayOf(1, 2, 3, 0)
        )
        val k = 1
        val result = solution.maxStability(n, edges, k)
        assertEquals(2, result, "Must edge [0,1] strength=2, optional [1,2] upgraded 3->6, min stability=2")
    }

    @Test
    @DisplayName("Example 2: n=3, all optional edges with k=2 upgrades - should return 6")
    fun testExample2() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 4, 0),
            intArrayOf(1, 2, 3, 0),
            intArrayOf(0, 2, 1, 0)
        )
        val k = 2
        val result = solution.maxStability(n, edges, k)
        assertEquals(6, result, "Upgrade [0,1] 4->8 and [1,2] 3->6, min stability=6")
    }

    @Test
    @DisplayName("Example 3: n=3, all must edges forming a cycle - should return -1")
    fun testExample3() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 2, 1, 1),
            intArrayOf(2, 0, 1, 1)
        )
        val k = 0
        val result = solution.maxStability(n, edges, k)
        assertEquals(-1, result, "All mandatory edges form a cycle, violating spanning tree acyclicity")
    }

    @Test
    @DisplayName("Not enough edges to form spanning tree - should return -1")
    fun testNotEnoughEdges() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(0, 1, 5, 0),
            intArrayOf(1, 2, 3, 0)
        )
        val k = 1
        val result = solution.maxStability(n, edges, k)
        assertEquals(-1, result, "Only 2 edges for 4 nodes, need at least 3")
    }

    @Test
    @DisplayName("Too many must edges - should return -1")
    fun testTooManyMustEdges() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 5, 1),
            intArrayOf(1, 2, 3, 1),
            intArrayOf(0, 2, 4, 1)
        )
        val k = 0
        val result = solution.maxStability(n, edges, k)
        assertEquals(-1, result, "3 must edges for 3 nodes exceeds n-1=2, forming a cycle")
    }

    @Test
    @DisplayName("Single edge spanning tree (n=2) - should return edge strength")
    fun testTwoNodes() {
        val n = 2
        val edges = arrayOf(
            intArrayOf(0, 1, 7, 0)
        )
        val k = 1
        val result = solution.maxStability(n, edges, k)
        assertEquals(14, result, "Single optional edge upgraded from 7 to 14")
    }

    @Test
    @DisplayName("No upgrades needed, all optional edges strong enough - should return min strength")
    fun testNoUpgradesNeeded() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0, 1, 10, 0),
            intArrayOf(1, 2, 8, 0)
        )
        val k = 0
        val result = solution.maxStability(n, edges, k)
        assertEquals(8, result, "Both optional edges used without upgrades, min stability=8")
    }

    @Test
    @DisplayName("Must edges with duplicate nodes forming cycle - should return -1")
    fun testMustEdgesCycle() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(0, 1, 5, 1),
            intArrayOf(1, 0, 3, 1),
            intArrayOf(2, 3, 4, 0)
        )
        val k = 1
        val result = solution.maxStability(n, edges, k)
        assertEquals(-1, result, "Must edges [0,1] and [1,0] connect the same nodes, creating a cycle")
    }
}
