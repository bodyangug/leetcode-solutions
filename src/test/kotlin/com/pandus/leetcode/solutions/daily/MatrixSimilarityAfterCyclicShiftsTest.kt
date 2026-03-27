package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MatrixSimilarityAfterCyclicShiftsTest {
    private val solver = MatrixSimilarityAfterCyclicShifts()

    @Test
    @DisplayName("Example 1: [[1,2,3],[4,5,6],[7,8,9]], k=4 -> false")
    fun areSimilar_example1() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(false, solver.areSimilar(mat, 4))
    }

    @Test
    @DisplayName("Example 2: [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k=2 -> true")
    fun areSimilar_example2() {
        val mat = arrayOf(
            intArrayOf(1, 2, 1, 2),
            intArrayOf(5, 5, 5, 5),
            intArrayOf(6, 3, 6, 3)
        )
        assertEquals(true, solver.areSimilar(mat, 2))
    }

    @Test
    @DisplayName("Example 3: [[2,2],[2,2]], k=3 -> true")
    fun areSimilar_example3() {
        val mat = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(2, 2)
        )
        assertEquals(true, solver.areSimilar(mat, 3))
    }

    @Test
    @DisplayName("Edge case: k=0, no shift applied -> true")
    fun areSimilar_noShift() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        assertEquals(true, solver.areSimilar(mat, 0))
    }

    @Test
    @DisplayName("Edge case: k equals column count, full cycle -> true")
    fun areSimilar_fullCycleShift() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        assertEquals(true, solver.areSimilar(mat, 3))
    }

    @Test
    @DisplayName("Edge case: single row matrix [[1,2,3]], k=1 -> false")
    fun areSimilar_singleRow() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3)
        )
        assertEquals(false, solver.areSimilar(mat, 1))
    }

    @Test
    @DisplayName("Edge case: single column matrix [[1],[2],[3]], k=1 -> true")
    fun areSimilar_singleColumn() {
        val mat = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3)
        )
        assertEquals(true, solver.areSimilar(mat, 1))
    }

    @Test
    @DisplayName("Edge case: 1x1 matrix [[5]], k=100 -> true")
    fun areSimilar_singleElement() {
        val mat = arrayOf(
            intArrayOf(5)
        )
        assertEquals(true, solver.areSimilar(mat, 100))
    }
}
