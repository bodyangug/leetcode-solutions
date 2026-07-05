package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NetworkRecoveryPathwaysTest {
    private val solution = NetworkRecoveryPathways()

    @Test
    fun findMaxPathScore_example1_returns3() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5),
            intArrayOf(1, 3, 10),
            intArrayOf(0, 2, 3),
            intArrayOf(2, 3, 4)
        )
        val online = booleanArrayOf(true, true, true, true)
        assertEquals(3, solution.findMaxPathScore(edges, online, 10L))
    }

    @Test
    fun findMaxPathScore_example2_returns6() {
        val edges = arrayOf(
            intArrayOf(0, 1, 7),
            intArrayOf(1, 4, 5),
            intArrayOf(0, 2, 6),
            intArrayOf(2, 3, 6),
            intArrayOf(3, 4, 2),
            intArrayOf(2, 4, 6)
        )
        val online = booleanArrayOf(true, true, true, false, true)
        assertEquals(6, solution.findMaxPathScore(edges, online, 12L))
    }

    @Test
    fun findMaxPathScore_noPathBecauseOfCost_returnsMinusOne() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5),
            intArrayOf(1, 2, 5)
        )
        val online = booleanArrayOf(true, true, true)
        assertEquals(-1, solution.findMaxPathScore(edges, online, 9L))
    }

    @Test
    fun findMaxPathScore_noPathBecauseOfOfflineNode_returnsMinusOne() {
        val edges = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 2)
        )
        val online = booleanArrayOf(true, false, true)
        assertEquals(-1, solution.findMaxPathScore(edges, online, 100L))
    }

    @Test
    fun findMaxPathScore_directEdgeFromSourceToDestination_returnsEdgeCost() {
        val edges = arrayOf(
            intArrayOf(0, 1, 7)
        )
        val online = booleanArrayOf(true, true)
        assertEquals(7, solution.findMaxPathScore(edges, online, 10L))
    }

    @Test
    fun findMaxPathScore_multiplePathsPicksHigherMinimum() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 3, 10),
            intArrayOf(0, 2, 4),
            intArrayOf(2, 3, 5)
        )
        val online = booleanArrayOf(true, true, true, true)
        assertEquals(4, solution.findMaxPathScore(edges, online, 20L))
    }

    @Test
    fun findMaxPathScore_kEqualsExactCost_returnsCorrectScore() {
        val edges = arrayOf(
            intArrayOf(0, 1, 3),
            intArrayOf(1, 2, 4)
        )
        val online = booleanArrayOf(true, true, true)
        assertEquals(3, solution.findMaxPathScore(edges, online, 7L))
    }

    @Test
    fun findMaxPathScore_noOutgoingEdgesFromZero_returnsMinusOne() {
        val edges = arrayOf(
            intArrayOf(1, 2, 5)
        )
        val online = booleanArrayOf(true, true, true)
        assertEquals(-1, solution.findMaxPathScore(edges, online, 10L))
    }

    @Test
    fun findMaxPathScore_longChain_returnsMinEdge() {
        val edges = arrayOf(
            intArrayOf(0, 1, 8),
            intArrayOf(1, 2, 2),
            intArrayOf(2, 3, 9),
            intArrayOf(3, 4, 5)
        )
        val online = booleanArrayOf(true, true, true, true, true)
        assertEquals(2, solution.findMaxPathScore(edges, online, 100L))
    }

    @Test
    fun findMaxPathScore_offlineNodeForcesLongerRoute() {
        val edges = arrayOf(
            intArrayOf(0, 1, 10),
            intArrayOf(1, 3, 10),
            intArrayOf(0, 2, 1),
            intArrayOf(2, 3, 1)
        )
        val online = booleanArrayOf(true, false, true, true)
        assertEquals(1, solution.findMaxPathScore(edges, online, 5L))
    }

    @Test
    fun findMaxPathScore_largeKValue_handlesLongOverflowSafely() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1_000_000_000),
            intArrayOf(1, 2, 1_000_000_000)
        )
        val online = booleanArrayOf(true, true, true)
        assertEquals(1_000_000_000, solution.findMaxPathScore(edges, online, 4_000_000_000L))
    }
}
