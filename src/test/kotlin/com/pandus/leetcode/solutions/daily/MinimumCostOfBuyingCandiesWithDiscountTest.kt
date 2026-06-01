package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostOfBuyingCandiesWithDiscountTest {
    private val solution = MinimumCostOfBuyingCandiesWithDiscount()

    @Test
    fun minimumCost_example1_returns5() {
        val cost = intArrayOf(1, 2, 3)
        assertEquals(5, solution.minimumCost(cost))
    }

    @Test
    fun minimumCost_example2_returns23() {
        val cost = intArrayOf(6, 5, 7, 9, 2, 2)
        assertEquals(23, solution.minimumCost(cost))
    }

    @Test
    fun minimumCost_example3_returns10() {
        val cost = intArrayOf(5, 5)
        assertEquals(10, solution.minimumCost(cost))
    }

    @Test
    fun minimumCost_singleCandy_returnsCost() {
        val cost = intArrayOf(7)
        assertEquals(7, solution.minimumCost(cost))
    }

    @Test
    fun minimumCost_allSameValues_returnsCorrectCost() {
        val cost = intArrayOf(3, 3, 3)
        assertEquals(6, solution.minimumCost(cost))
    }
}
