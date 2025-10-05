package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockTest {

    private val solution = BestTimeToBuyAndSellStock()

    @Test
    fun testExample1() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        assertEquals(5, solution.maxProfit(prices)) // Buy at 1, sell at 6
        assertEquals(5, solution.maxProfit1(prices)) // Test brute force solution
    }

    @Test
    fun testExample2() {
        val prices = intArrayOf(7, 6, 4, 3, 1)
        assertEquals(0, solution.maxProfit(prices)) // No profit possible
        assertEquals(0, solution.maxProfit1(prices))
    }

    @Test
    fun testSinglePrice() {
        val prices = intArrayOf(5)
        assertEquals(0, solution.maxProfit(prices))
        assertEquals(0, solution.maxProfit1(prices))
    }

    @Test
    fun testIncreasingPrices() {
        val prices = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(4, solution.maxProfit(prices)) // Buy at 1, sell at 5
        assertEquals(4, solution.maxProfit1(prices))
    }

    @Test
    fun testDecreasingPrices() {
        val prices = intArrayOf(5, 4, 3, 2, 1)
        assertEquals(0, solution.maxProfit(prices)) // No profit possible
        assertEquals(0, solution.maxProfit1(prices))
    }

    @Test
    fun testMixedPrices() {
        val prices = intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)
        assertEquals(4, solution.maxProfit(prices)) // Buy at 0, sell at 4
        assertEquals(4, solution.maxProfit1(prices))
    }
}
