package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumAmountOfMoneyRobotCanEarnTest {
    @Test
    @DisplayName("Example 1: Mixed values with robbers, optimal path uses neutralization")
    fun maximumAmount_example1() {
        val solution = MaximumAmountOfMoneyRobotCanEarn()
        val coins = arrayOf(
            intArrayOf(0, 1, -1),
            intArrayOf(1, -2, 3),
            intArrayOf(2, -3, 4)
        )
        assertEquals(8, solution.maximumAmount(coins))
    }

    @Test
    @DisplayName("Example 2: All positive values, no neutralization needed")
    fun maximumAmount_example2() {
        val solution = MaximumAmountOfMoneyRobotCanEarn()
        val coins = arrayOf(
            intArrayOf(10, 10, 10),
            intArrayOf(10, 10, 10)
        )
        assertEquals(40, solution.maximumAmount(coins))
    }

    @Test
    @DisplayName("Single cell grid with positive value")
    fun maximumAmount_singleCellPositive() {
        val solution = MaximumAmountOfMoneyRobotCanEarn()
        val coins = arrayOf(intArrayOf(5))
        assertEquals(5, solution.maximumAmount(coins))
    }

    @Test
    @DisplayName("Single cell grid with negative value, neutralized to 0")
    fun maximumAmount_singleCellNegative() {
        val solution = MaximumAmountOfMoneyRobotCanEarn()
        val coins = arrayOf(intArrayOf(-5))
        assertEquals(0, solution.maximumAmount(coins))
    }

    @Test
    @DisplayName("All negative values, neutralize the two worst robbers")
    fun maximumAmount_allNegative() {
        val solution = MaximumAmountOfMoneyRobotCanEarn()
        val coins = arrayOf(
            intArrayOf(-1, -2),
            intArrayOf(-3, -4)
        )
        // Path: (0,0) -> (0,1) -> (1,1): values -1, -2, -4; neutralize -2 and -4 => -1
        // Path: (0,0) -> (1,0) -> (1,1): values -1, -3, -4; neutralize -3 and -4 => -1
        assertEquals(-1, solution.maximumAmount(coins))
    }

    @Test
    @DisplayName("Single row grid")
    fun maximumAmount_singleRow() {
        val solution = MaximumAmountOfMoneyRobotCanEarn()
        val coins = arrayOf(intArrayOf(1, -5, 3, -2, 4))
        // Only path: 1, -5, 3, -2, 4; neutralize -5 and -2 => 1+3+4 = 8
        assertEquals(8, solution.maximumAmount(coins))
    }

    @Test
    @DisplayName("Single column grid")
    fun maximumAmount_singleColumn() {
        val solution = MaximumAmountOfMoneyRobotCanEarn()
        val coins = arrayOf(
            intArrayOf(2),
            intArrayOf(-3),
            intArrayOf(4),
            intArrayOf(-1),
            intArrayOf(5)
        )
        // Only path: 2, -3, 4, -1, 5; neutralize -3 and -1 => 2+4+5 = 11
        assertEquals(11, solution.maximumAmount(coins))
    }

    @Test
    @DisplayName("Grid with all zeros")
    fun maximumAmount_allZeros() {
        val solution = MaximumAmountOfMoneyRobotCanEarn()
        val coins = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertEquals(0, solution.maximumAmount(coins))
    }
}
