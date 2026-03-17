package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LargestSubmatrixWithRearrangementsTest {
    private val solver = LargestSubmatrixWithRearrangements()

    @Test
    @DisplayName("Example 1: 3x3 matrix with largest submatrix area 4")
    fun largestSubmatrix_example1() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1)
        )
        assertEquals(4, solver.largestSubmatrix(matrix))
    }

    @Test
    @DisplayName("Example 2: single row matrix with area 3")
    fun largestSubmatrix_example2() {
        val matrix = arrayOf(
            intArrayOf(1, 0, 1, 0, 1)
        )
        assertEquals(3, solver.largestSubmatrix(matrix))
    }

    @Test
    @DisplayName("Example 3: 2x3 matrix with largest submatrix area 2")
    fun largestSubmatrix_example3() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        assertEquals(2, solver.largestSubmatrix(matrix))
    }

    @Test
    @DisplayName("All ones matrix returns full area")
    fun largestSubmatrix_allOnes() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(6, solver.largestSubmatrix(matrix))
    }

    @Test
    @DisplayName("All zeros matrix returns 0")
    fun largestSubmatrix_allZeros() {
        val matrix = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertEquals(0, solver.largestSubmatrix(matrix))
    }

    @Test
    @DisplayName("Single element 1 returns 1")
    fun largestSubmatrix_singleOne() {
        val matrix = arrayOf(
            intArrayOf(1)
        )
        assertEquals(1, solver.largestSubmatrix(matrix))
    }

    @Test
    @DisplayName("Single element 0 returns 0")
    fun largestSubmatrix_singleZero() {
        val matrix = arrayOf(
            intArrayOf(0)
        )
        assertEquals(0, solver.largestSubmatrix(matrix))
    }
}
