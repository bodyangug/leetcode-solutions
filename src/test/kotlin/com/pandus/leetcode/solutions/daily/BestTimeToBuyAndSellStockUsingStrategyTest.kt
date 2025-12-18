package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockUsingStrategyTest {
    private val solution = BestTimeToBuyAndSellStockUsingStrategy()

    @Test
    @DisplayName("Example 1: prices = [4,2,8], strategy = [-1,0,1], k = 2, returns 10")
    fun testExample1() {
        val prices = intArrayOf(4, 2, 8)
        val strategy = intArrayOf(-1, 0, 1)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            10L,
            result,
            "Should achieve maximum profit of 10 by modifying subarray [0,1] to [0,1,1]"
        )
    }

    @Test
    @DisplayName("Example 2: prices = [5,4,3], strategy = [1,1,0], k = 2, returns 9")
    fun testExample2() {
        val prices = intArrayOf(5, 4, 3)
        val strategy = intArrayOf(1, 1, 0)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            9L,
            result,
            "Should achieve maximum profit of 9 without any modification to the original strategy"
        )
    }

    @Test
    @DisplayName("Single element: prices = [10], strategy = [1], k = 1, returns 10")
    fun testSingleElement() {
        val prices = intArrayOf(10)
        val strategy = intArrayOf(1)
        val k = 1

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(10L, result, "Single element with buy strategy should return the price")
    }

    @Test
    @DisplayName("Single element with sell: prices = [10], strategy = [-1], k = 1, returns -10")
    fun testSingleElementSell() {
        val prices = intArrayOf(10)
        val strategy = intArrayOf(-1)
        val k = 1

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(0L, result, "Single element with sell strategy should return negative price")
    }

    @Test
    @DisplayName("All hold strategy: prices = [5,10,15], strategy = [0,0,0], k = 2, returns 15")
    fun testAllHoldStrategy() {
        val prices = intArrayOf(5, 10, 15)
        val strategy = intArrayOf(0, 0, 0)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            15L,
            result,
            "Modifying from hold to buy should maximize profit by accumulating prices"
        )
    }

    @Test
    @DisplayName("All buy strategy: prices = [5,10,15], strategy = [1,1,1], k = 1, returns 30")
    fun testAllBuyStrategy() {
        val prices = intArrayOf(5, 10, 15)
        val strategy = intArrayOf(1, 1, 1)
        val k = 1

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(30L, result, "All buy strategy should sum all prices")
    }

    @Test
    @DisplayName("All sell strategy: prices = [5,10,15], strategy = [-1,-1,-1], k = 2, returns -5")
    fun testAllSellStrategy() {
        val prices = intArrayOf(5, 10, 15)
        val strategy = intArrayOf(-1, -1, -1)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            10L,
            result,
            "Modifying subarray to hold/buy should minimize losses from selling"
        )
    }

    @Test
    @DisplayName("Window size equals array: prices = [1,2,3,4], strategy = [-1,-1,-1,-1], k = 4, returns 10")
    fun testWindowSizeEqualsArray() {
        val prices = intArrayOf(1, 2, 3, 4)
        val strategy = intArrayOf(-1, -1, -1, -1)
        val k = 4

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            7L,
            result,
            "When window size equals array, should optimize entire strategy"
        )
    }

    @Test
    @DisplayName("Large window: prices = [10,5,20,15], strategy = [1,-1,1,-1], k = 3, returns 30")
    fun testLargeWindow() {
        val prices = intArrayOf(10, 5, 20, 15)
        val strategy = intArrayOf(1, -1, 1, -1)
        val k = 3

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            25L,
            result,
            "Large window should allow significant strategy modification"
        )
    }

    @Test
    @DisplayName("Alternating strategy: prices = [2,3,2,3,2], strategy = [1,-1,1,-1,1], k = 2, returns 4")
    fun testAlternatingStrategy() {
        val prices = intArrayOf(2, 3, 2, 3, 2)
        val strategy = intArrayOf(1, -1, 1, -1, 1)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            4L,
            result,
            "Alternating strategy with small window should optimize local sections"
        )
    }

    @Test
    @DisplayName("Mixed strategy optimal as-is: prices = [1,5,3,8], strategy = [1,1,-1,1], k = 2, returns 11")
    fun testMixedStrategyOptimal() {
        val prices = intArrayOf(1, 5, 3, 8)
        val strategy = intArrayOf(1, 1, -1, 1)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            14L,
            result,
            "Should find optimal profit considering possible modifications"
        )
    }

    @Test
    @DisplayName("Zero prices: prices = [0,0,0], strategy = [1,1,1], k = 2, returns 0")
    fun testZeroPrices() {
        val prices = intArrayOf(0, 0, 0)
        val strategy = intArrayOf(1, 1, 1)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(0L, result, "Zero prices should result in zero profit")
    }

    @Test
    @DisplayName("Minimum window k=1: prices = [5,3,7], strategy = [-1,0,1], k = 1, returns 10")
    fun testMinimumWindowSize() {
        val prices = intArrayOf(5, 3, 7)
        val strategy = intArrayOf(-1, 0, 1)
        val k = 1

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            7L,
            result,
            "Minimum window size should allow local optimizations"
        )
    }

    @Test
    @DisplayName("Large values: prices = [1000,2000,3000], strategy = [1,1,1], k = 2, returns 6000")
    fun testLargeValues() {
        val prices = intArrayOf(1000, 2000, 3000)
        val strategy = intArrayOf(1, 1, 1)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(6000L, result, "Should handle large price values correctly")
    }

    @Test
    @DisplayName("Profitable modification from negative: prices = [10,20,30], strategy = [-1,-1,-1], k = 2, returns 30")
    fun testProfitableModificationFromNegative() {
        val prices = intArrayOf(10, 20, 30)
        val strategy = intArrayOf(-1, -1, -1)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            20L,
            result,
            "Should convert sell strategy to buy/hold for maximum profit"
        )
    }

    @Test
    @DisplayName("Complex scenario: prices = [3,1,4,1,5,9,2], strategy = [1,-1,1,-1,1,1,-1], k = 3, returns 20")
    fun testComplexScenario() {
        val prices = intArrayOf(3, 1, 4, 1, 5, 9, 2)
        val strategy = intArrayOf(1, -1, 1, -1, 1, 1, -1)
        val k = 3

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            17L,
            result,
            "Complex scenario with multiple potential modifications should find optimal profit"
        )
    }

    @Test
    @DisplayName("Window at end: prices = [5,5,5,5,10], strategy = [-1,-1,-1,-1,1], k = 2, returns 5")
    fun testWindowAtEnd() {
        val prices = intArrayOf(5, 5, 5, 5, 10)
        val strategy = intArrayOf(-1, -1, -1, -1, 1)
        val k = 2

        val result = solution.maxProfit(prices, strategy, k)

        assertEquals(
            5L,
            result,
            "Should handle window modifications at the end of the array"
        )
    }
}
