package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToAssignEdgeWeightsITest {
    private val solution = NumberOfWaysToAssignEdgeWeightsI()

    @Test
    fun `example 1 single edge`() {
        val edges = arrayOf(intArrayOf(1, 2))
        assertEquals(1, solution.assignEdgeWeights(edges))
    }

    @Test
    fun `example 2 max depth two`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(3, 4),
            intArrayOf(3, 5),
        )
        assertEquals(2, solution.assignEdgeWeights(edges))
    }

    @Test
    fun `linear chain depth three`() {
        // 1 -> 2 -> 3 -> 4, depth = 3, answer = 2^(3-1) = 4
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
        )
        assertEquals(4, solution.assignEdgeWeights(edges))
    }

    @Test
    fun `linear chain depth four`() {
        // depth 4 -> 2^3 = 8
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
        )
        assertEquals(8, solution.assignEdgeWeights(edges))
    }

    @Test
    fun `star graph depth one`() {
        // root with many direct children, max depth = 1, answer = 2^0 = 1
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(1, 5),
        )
        assertEquals(1, solution.assignEdgeWeights(edges))
    }

    @Test
    fun `edges given in arbitrary order`() {
        // Path 1-3-2-4 depth 3, mixed edge orientation
        val edges = arrayOf(
            intArrayOf(4, 2),
            intArrayOf(3, 1),
            intArrayOf(2, 3),
        )
        assertEquals(4, solution.assignEdgeWeights(edges))
    }

    @Test
    fun `large depth uses modular exponentiation`() {
        // Linear chain of 100000 nodes -> depth 99999 -> 2^99998 mod 1e9+7
        val n = 100_000
        val edges = Array(n - 1) { i -> intArrayOf(i + 1, i + 2) }
        val mod = 1_000_000_007L
        var expected = 1L
        var base = 2L
        var exp = (n - 2).toLong()
        while (exp > 0) {
            if (exp and 1L == 1L) expected = expected * base % mod
            base = base * base % mod
            exp = exp shr 1
        }
        assertEquals(expected.toInt(), solution.assignEdgeWeights(edges))
    }

    @Test
    fun `unbalanced tree deepest branch wins`() {
        // Tree:
        // 1 - 2
        // 1 - 3 - 4 - 5 (deepest, depth 3)
        // 1 - 6 - 7
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(1, 6),
            intArrayOf(6, 7),
        )
        assertEquals(4, solution.assignEdgeWeights(edges))
    }
}

