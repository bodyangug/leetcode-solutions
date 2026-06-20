package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBuildingHeightTest {
    private val solution = MaximumBuildingHeight()

    @Test
    fun maxBuilding_example1_returnsTwo() {
        // n = 5, restrictions = [[2,1],[4,1]] → 2
        val restrictions = arrayOf(intArrayOf(2, 1), intArrayOf(4, 1))
        assertEquals(2, solution.maxBuilding(5, restrictions))
    }

    @Test
    fun maxBuilding_example2_noRestrictions_returnsNMinusOne() {
        // n = 6, restrictions = [] → 5
        assertEquals(5, solution.maxBuilding(6, emptyArray()))
    }

    @Test
    fun maxBuilding_example3_multipleRestrictions_returnsFive() {
        // n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]] → 5
        val restrictions = arrayOf(
            intArrayOf(5, 3),
            intArrayOf(2, 5),
            intArrayOf(7, 4),
            intArrayOf(10, 3)
        )
        assertEquals(5, solution.maxBuilding(10, restrictions))
    }

    @Test
    fun maxBuilding_singleBuilding_returnsZero() {
        // n = 1, only building 1 with height 0
        assertEquals(0, solution.maxBuilding(1, emptyArray()))
    }

    @Test
    fun maxBuilding_twoBuildings_noRestrictions_returnsOne() {
        // n = 2 → heights [0,1] → 1
        assertEquals(1, solution.maxBuilding(2, emptyArray()))
    }

    @Test
    fun maxBuilding_restrictionAtLastBuilding_limitsHeight() {
        // n = 5, restriction at building 5 with height 1
        // Heights: [0,1,2,2,1] → max 2
        val restrictions = arrayOf(intArrayOf(5, 1))
        assertEquals(2, solution.maxBuilding(5, restrictions))
    }

    @Test
    fun maxBuilding_restrictionHigherThanReachable_doesNotIncreaseHeight() {
        // n = 4, restriction at building 2 with height 100
        // Building 2 limited to 1 (from building 1 height 0)
        // Heights: [0,1,2,3] → max 3
        val restrictions = arrayOf(intArrayOf(2, 100))
        assertEquals(3, solution.maxBuilding(4, restrictions))
    }

    @Test
    fun maxBuilding_restrictionsUnsorted_handledCorrectly() {
        // Same as example 3 but explicit
        val restrictions = arrayOf(
            intArrayOf(10, 3),
            intArrayOf(2, 5),
            intArrayOf(7, 4),
            intArrayOf(5, 3)
        )
        assertEquals(5, solution.maxBuilding(10, restrictions))
    }

    @Test
    fun maxBuilding_singleRestrictionInMiddle_largeN() {
        // n = 100, restriction at building 50 with height 0
        // Heights climb from 0..49 then 0 at 50 then climb to 49 at 99 → max 49
        val restrictions = arrayOf(intArrayOf(50, 0))
        assertEquals(49, solution.maxBuilding(100, restrictions))
    }

    @Test
    fun maxBuilding_zeroHeightRestrictionAtEnd_returnsZero() {
        // n = 1 trivial zero case already covered; test n=2 with restriction at 2 height 0
        val restrictions = arrayOf(intArrayOf(2, 0))
        assertEquals(0, solution.maxBuilding(2, restrictions))
    }
}
