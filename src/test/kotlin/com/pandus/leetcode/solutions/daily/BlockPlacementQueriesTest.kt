package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BlockPlacementQueriesTest {
    private val solution = BlockPlacementQueries()

    @Test
    fun getResults_example1_returnsCorrectResults() {
        // queries = [[1,2],[2,3,3],[2,3,1],[2,2,2]]
        // Output: [false, true, true]
        val queries = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3, 3),
            intArrayOf(2, 3, 1),
            intArrayOf(2, 2, 2)
        )
        assertEquals(listOf(false, true, true), solution.getResults(queries))
    }

    @Test
    fun getResults_example2_returnsCorrectResults() {
        // queries = [[1,7],[2,7,6],[1,2],[2,7,5],[2,7,6]]
        // Output: [true, true, false]
        val queries = arrayOf(
            intArrayOf(1, 7),
            intArrayOf(2, 7, 6),
            intArrayOf(1, 2),
            intArrayOf(2, 7, 5),
            intArrayOf(2, 7, 6)
        )
        assertEquals(listOf(true, true, false), solution.getResults(queries))
    }

    @Test
    fun getResults_noObstacles_alwaysTrue() {
        val queries = arrayOf(
            intArrayOf(2, 5, 3),
            intArrayOf(2, 10, 10)
        )
        assertEquals(listOf(true, true), solution.getResults(queries))
    }

    @Test
    fun getResults_blockExactlyFitsEntireRange_returnsTrue() {
        // No obstacles, x=5, sz=5 → gap [0,5]=5 ≥ 5
        val queries = arrayOf(intArrayOf(2, 5, 5))
        assertEquals(listOf(true), solution.getResults(queries))
    }

    @Test
    fun getResults_blockTooLargeForRange_returnsFalse() {
        // No obstacles, x=3, sz=4 → gap [0,3]=3 < 4
        val queries = arrayOf(intArrayOf(2, 3, 4))
        assertEquals(listOf(false), solution.getResults(queries))
    }

    @Test
    fun getResults_obstacleAtBoundary_blockTouchesObstacle() {
        // Obstacle at 3, query [2,5,2] → gaps: [0,3]=3, [3,5]=2; max=3 ≥ 2
        val queries = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 5, 2)
        )
        assertEquals(listOf(true), solution.getResults(queries))
    }

    @Test
    fun getResults_multipleObstacles_maxGapUsed() {
        // Obstacles at 2 and 4, query [2,7,3] → gaps: [0,2]=2, [2,4]=2, [4,7]=3; max=3 ≥ 3
        val queries = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 4),
            intArrayOf(2, 7, 3)
        )
        assertEquals(listOf(true), solution.getResults(queries))
    }

    @Test
    fun getResults_multipleObstacles_noGapLargeEnough() {
        // Obstacles at 2 and 4, query [2,7,4] → gaps: [0,2]=2, [2,4]=2, [4,7]=3; max=3 < 4
        val queries = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 4),
            intArrayOf(2, 7, 4)
        )
        assertEquals(listOf(false), solution.getResults(queries))
    }

    @Test
    fun getResults_obstaclesBeyondX_ignored() {
        // Obstacle at 10, query [2,5,5] → obstacle beyond x=5, ignored; gap [0,5]=5 ≥ 5
        val queries = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(2, 5, 5)
        )
        assertEquals(listOf(true), solution.getResults(queries))
    }

    @Test
    fun getResults_singleObstacleAtOne_smallBlock() {
        // Obstacle at 1, query [2,3,1] → gaps: [0,1]=1, [1,3]=2; max=2 ≥ 1
        val queries = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 3, 1)
        )
        assertEquals(listOf(true), solution.getResults(queries))
    }
}
