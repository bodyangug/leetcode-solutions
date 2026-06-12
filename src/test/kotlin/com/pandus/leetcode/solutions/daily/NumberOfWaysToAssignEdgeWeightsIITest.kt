package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToAssignEdgeWeightsIITest {
    private val solution = NumberOfWaysToAssignEdgeWeightsII()

    @Test
    fun `example 1 single edge with self and edge query`() {
        val edges = arrayOf(intArrayOf(1, 2))
        val queries = arrayOf(intArrayOf(1, 1), intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(0, 1), solution.assignEdgeWeights(edges, queries))
    }

    @Test
    fun `example 2 branching tree multiple queries`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(3, 4),
            intArrayOf(3, 5),
        )
        val queries = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(3, 4),
            intArrayOf(2, 5),
        )
        assertArrayEquals(intArrayOf(2, 1, 4), solution.assignEdgeWeights(edges, queries))
    }

    @Test
    fun `same node queries always zero`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
        )
        val queries = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(4, 4),
        )
        assertArrayEquals(intArrayOf(0, 0, 0), solution.assignEdgeWeights(edges, queries))
    }

    @Test
    fun `linear chain various path lengths`() {
        // 1-2-3-4-5
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
        )
        val queries = arrayOf(
            intArrayOf(1, 2), // len 1 -> 1
            intArrayOf(1, 3), // len 2 -> 2
            intArrayOf(1, 4), // len 3 -> 4
            intArrayOf(1, 5), // len 4 -> 8
            intArrayOf(2, 5), // len 3 -> 4
        )
        assertArrayEquals(intArrayOf(1, 2, 4, 8, 4), solution.assignEdgeWeights(edges, queries))
    }

    @Test
    fun `star graph queries through root`() {
        // 1 is root, children 2,3,4,5
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(1, 5),
        )
        val queries = arrayOf(
            intArrayOf(2, 3), // len 2 -> 2
            intArrayOf(4, 5), // len 2 -> 2
            intArrayOf(1, 5), // len 1 -> 1
            intArrayOf(2, 2), // 0
        )
        assertArrayEquals(intArrayOf(2, 2, 1, 0), solution.assignEdgeWeights(edges, queries))
    }

    @Test
    fun `edges given in arbitrary order`() {
        // Tree: 1-3, 3-2, 2-4 (path 1-3-2-4 length 3)
        val edges = arrayOf(
            intArrayOf(2, 4),
            intArrayOf(3, 2),
            intArrayOf(1, 3),
        )
        val queries = arrayOf(
            intArrayOf(1, 4), // len 3 -> 4
            intArrayOf(3, 4), // len 2 -> 2
            intArrayOf(4, 1), // len 3 -> 4
        )
        assertArrayEquals(intArrayOf(4, 2, 4), solution.assignEdgeWeights(edges, queries))
    }

    @Test
    fun `large linear chain uses modular arithmetic`() {
        val n = 100_000
        val edges = Array(n - 1) { i -> intArrayOf(i + 1, i + 2) }
        val queries = arrayOf(intArrayOf(1, n))
        val mod = 1_000_000_007L
        var expected = 1L
        var base = 2L
        var exp = (n - 2).toLong() // path length n-1, answer = 2^(n-2)
        while (exp > 0) {
            if (exp and 1L == 1L) expected = expected * base % mod
            base = base * base % mod
            exp = exp shr 1
        }
        assertArrayEquals(intArrayOf(expected.toInt()), solution.assignEdgeWeights(edges, queries))
    }

    @Test
    fun `lca deeper in tree`() {
        // Tree:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        //    /         \
        //   7           8
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 6),
            intArrayOf(4, 7),
            intArrayOf(6, 8),
        )
        val queries = arrayOf(
            intArrayOf(7, 5), // path 7-4-2-5, len 3 -> 4
            intArrayOf(7, 8), // path 7-4-2-1-3-6-8, len 6 -> 32
            intArrayOf(4, 5), // len 2 -> 2
            intArrayOf(8, 1), // len 3 -> 4
        )
        assertArrayEquals(intArrayOf(4, 32, 2, 4), solution.assignEdgeWeights(edges, queries))
    }
}
