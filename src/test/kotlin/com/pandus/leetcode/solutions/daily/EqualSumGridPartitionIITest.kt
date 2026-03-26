package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class EqualSumGridPartitionIITest {
    private val solver = EqualSumGridPartitionII()

    @Test
    @DisplayName("Example 1: horizontal cut gives equal sums, no discount needed")
    fun canPartitionGrid_example1() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
    }

    @Test
    @DisplayName("Example 2: vertical cut with discount on corner cell makes sums equal")
    fun canPartitionGrid_example2() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }

    @Test
    @DisplayName("Example 3: discounting inner cell breaks connectivity, no valid cut")
    fun canPartitionGrid_example3() {
        assertFalse(solver.canPartitionGrid(arrayOf(intArrayOf(1, 2, 4), intArrayOf(2, 3, 5))))
    }

    @Test
    @DisplayName("Example 4: no valid cut exists")
    fun canPartitionGrid_example4() {
        assertFalse(solver.canPartitionGrid(arrayOf(intArrayOf(4, 1, 8), intArrayOf(3, 2, 6))))
    }

    @Test
    @DisplayName("Equal sums without discount: horizontal cut")
    fun canPartitionGrid_equalSumsHorizontal() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(2, 3), intArrayOf(3, 2))))
    }

    @Test
    @DisplayName("Equal sums without discount: vertical cut")
    fun canPartitionGrid_equalSumsVertical() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    @DisplayName("Single column grid: horizontal cut with discount on last-row element")
    fun canPartitionGrid_singleColumnWithDiscount() {
        // col=[1,2,3]: cut after row 0 -> sum=1, tag=1*2-6=-4 (no); cut after row 1 -> sum=3, tag=3*2-6=0 -> true
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))))
    }

    @Test
    @DisplayName("Single column grid: no valid cut")
    fun canPartitionGrid_singleColumnNoValidCut() {
        // col=[1,3]: cut after row 0 -> sum=1, tag=2-4=-2; no match
        assertFalse(solver.canPartitionGrid(arrayOf(intArrayOf(1), intArrayOf(3))))
    }

    @Test
    @DisplayName("Single row grid: vertical cut with equal sums")
    fun canPartitionGrid_singleRowEqualSums() {
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(5, 5))))
    }

    @Test
    @DisplayName("Discount on top-left corner allows equal sums after horizontal cut")
    fun canPartitionGrid_discountTopLeftCorner() {
        // top row sum=10 (e.g. [6,4]), bottom row sum=4 ([2,2]); tag = 10*2-14=6; top-left=6 -> true
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(6, 4), intArrayOf(2, 2))))
    }

    @Test
    @DisplayName("Discount on top-right corner allows equal sums after horizontal cut")
    fun canPartitionGrid_discountTopRightCorner() {
        // top=[2,6], bottom=[4,4]; total=16; after row 0: sum=8, tag=0 -> true (equal, no discount)
        assertTrue(solver.canPartitionGrid(arrayOf(intArrayOf(2, 6), intArrayOf(4, 4))))
    }

    @Test
    @DisplayName("Large grid with valid horizontal cut")
    fun canPartitionGrid_largeGridHorizontalCut() {
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
    @DisplayName("No overflow on large values")
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
