package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class EqualSumGridPartitionITest {
    private val solver = EqualSumGridPartitionI()

    @Test
    @DisplayName("Example 1: horizontal cut between row 0 and row 1 gives equal sums")
    fun canPartitionGrid_example1() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
    }

    @Test
    @DisplayName("Example 2: no valid horizontal or vertical cut exists")
    fun canPartitionGrid_example2() {
        assertFalse(solver.canPartitionGrid(arrayOf(intArrayOf(1, 3), intArrayOf(2, 4))))
    }

    @Test
    @DisplayName("Vertical cut: single column cut gives equal sums")
    fun canPartitionGrid_verticalCut() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(1, 2), intArrayOf(1, 2))))
    }

    @Test
    @DisplayName("Odd total sum: early return false")
    fun canPartitionGrid_oddTotal() {
        assertFalse(solver.canPartitionGrid(arrayOf(intArrayOf(1, 2), intArrayOf(1, 1))))
    }

    @Test
    @DisplayName("Single row: only vertical cuts possible, valid cut exists")
    fun canPartitionGrid_singleRow() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(3, 3))))
    }

    @Test
    @DisplayName("Single column: only horizontal cuts possible, valid cut exists")
    fun canPartitionGrid_singleColumn() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(5), intArrayOf(5))))
    }

    @Test
    @DisplayName("Large grid: horizontal cut at middle row")
    fun canPartitionGrid_largeGridHorizontal() {
        assertTrue(
            solver.canPartitionGrid(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1)
                )
            )
        )
    }

    @Test
    @DisplayName("Large values: no overflow, no valid cut")
    fun canPartitionGrid_largeValues() {
        assertFalse(
            solver.canPartitionGrid(
                arrayOf(
                    intArrayOf(Int.MAX_VALUE, 1),
                    intArrayOf(1, 1)
                )
            )
        )
    }
}
