package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeHammingDistanceAfterSwapOperationsTest {
    private val solution = MinimizeHammingDistanceAfterSwapOperations()

    @Test
    fun `example 1 - swap indices reduce hamming distance`() {
        assertEquals(
            1,
            solution.minimumHammingDistance(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(2, 1, 4, 5),
                arrayOf(intArrayOf(0, 1), intArrayOf(2, 3))
            )
        )
    }

    @Test
    fun `example 2 - no swaps allowed`() {
        assertEquals(
            2,
            solution.minimumHammingDistance(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(1, 3, 2, 4),
                emptyArray()
            )
        )
    }

    @Test
    fun `example 3 - all elements matchable via swaps`() {
        assertEquals(
            0,
            solution.minimumHammingDistance(
                intArrayOf(5, 1, 2, 4, 3),
                intArrayOf(1, 5, 4, 2, 3),
                arrayOf(intArrayOf(0, 4), intArrayOf(4, 2), intArrayOf(1, 3), intArrayOf(1, 4))
            )
        )
    }
}
