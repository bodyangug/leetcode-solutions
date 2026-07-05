package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumScoreOfPathBetweenTwoCitiesTest {
    private val solution = MinimumScoreOfPathBetweenTwoCities()

    @Test
    fun minScore_returnsMinimumEdgeOnConnectedPath_example1() {
        val roads = arrayOf(
            intArrayOf(1, 2, 9),
            intArrayOf(2, 3, 6),
            intArrayOf(2, 4, 5),
            intArrayOf(1, 4, 7),
        )

        assertEquals(5, solution.minScore(4, roads))
    }

    @Test
    fun minScore_returnsMinimumEdgeEvenWhenPathLoopsThroughSource_example2() {
        val roads = arrayOf(
            intArrayOf(1, 2, 2),
            intArrayOf(1, 3, 4),
            intArrayOf(3, 4, 7),
        )

        assertEquals(2, solution.minScore(4, roads))
    }
}
