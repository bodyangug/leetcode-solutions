package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockTest {
    @Test
    fun maxProfit_returnsCorrectProfit_positiveCase() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val solution = BestTimeToBuyAndSellStock()
        assertEquals(5, solution.maxProfit(prices))
    }

    @Test
    fun maxProfit_returnsZeroForDescendingPrices_negativeCase() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        val solution = BestTimeToBuyAndSellStock()
        assertEquals(0, solution.maxProfit(prices))
    }
}
