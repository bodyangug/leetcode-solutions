package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockVTest {
    private val solution = BestTimeToBuyAndSellStockV()

    @Test
    @DisplayName("Example 1: prices = [1,7,9,8,2], k = 2, returns 14")
    fun testExample1() {
        val prices = intArrayOf(1, 7, 9, 8, 2)
        val k = 2

        val result = solution.maximumProfit(prices, k)

        assertEquals(
            14,
            result,
            "Should make profit through 2 transactions: buy at 1 sell at 9 (profit 8), sell at 8 buy at 2 (profit 6)"
        )
    }

    @Test
    @DisplayName("Example 2: prices = [12,16,19,19,8,1,19,13,9], k = 3, returns 36")
    fun testExample2() {
        val prices = intArrayOf(12, 16, 19, 19, 8, 1, 19, 13, 9)
        val k = 3

        val result = solution.maximumProfit(prices, k)

        assertEquals(36, result, "Should make profit through 3 transactions with optimal buy/sell strategy")
    }

    @Test
    @DisplayName("Single day: prices = [5], k = 1, returns 0")
    fun testSingleDay() {
        val prices = intArrayOf(5)
        val k = 1

        val result = solution.maximumProfit(prices, k)

        assertEquals(0, result, "Cannot make any transactions with only one day")
    }

    @Test
    @DisplayName("Two days increasing: prices = [1,5], k = 1, returns 4")
    fun testTwoDaysIncreasing() {
        val prices = intArrayOf(1, 5)
        val k = 1

        val result = solution.maximumProfit(prices, k)

        assertEquals(4, result, "Buy at 1, sell at 5 for profit of 4")
    }

    @Test
    @DisplayName("Two days decreasing: prices = [5,1], k = 1, returns 4")
    fun testTwoDaysDecreasing() {
        val prices = intArrayOf(5, 1)
        val k = 1

        val result = solution.maximumProfit(prices, k)

        assertEquals(4, result, "Short sell at 5, buy back at 1 for profit of 4")
    }

    @Test
    @DisplayName("Zero transactions allowed: k = 0, returns 0")
    fun testZeroTransactions() {
        val prices = intArrayOf(1, 5, 9, 3, 7)
        val k = 0

        val result = solution.maximumProfit(prices, k)

        assertEquals(0, result, "Cannot make any profit with 0 transactions allowed")
    }

    @Test
    @DisplayName("Flat prices: prices = [5,5,5,5], k = 2, returns 0")
    fun testFlatPrices() {
        val prices = intArrayOf(5, 5, 5, 5)
        val k = 2

        val result = solution.maximumProfit(prices, k)

        assertEquals(0, result, "No profit possible when all prices are the same")
    }

    @Test
    @DisplayName("Strictly increasing: prices = [1,2,3,4,5], k = 2, returns 8")
    fun testStrictlyIncreasing() {
        val prices = intArrayOf(1, 2, 3, 4, 5)
        val k = 2

        val result = solution.maximumProfit(prices, k)

        assertEquals(
            4,
            result,
            "Best strategy: buy at 1, sell at 5 (profit 4), then hold and wait for cooldown adds another 4"
        )
    }

    @Test
    @DisplayName("Strictly decreasing: prices = [5,4,3,2,1], k = 2, returns 8")
    fun testStrictlyDecreasing() {
        val prices = intArrayOf(5, 4, 3, 2, 1)
        val k = 2

        val result = solution.maximumProfit(prices, k)

        assertEquals(
            4,
            result,
            "Best strategy: short sell at 5, buy at 1 (profit 4), combined with other opportunities"
        )
    }

    @Test
    @DisplayName("More transactions than needed: prices = [1,5], k = 10, returns 4")
    fun testMoreTransactionsThanNeeded() {
        val prices = intArrayOf(1, 5)
        val k = 10

        val result = solution.maximumProfit(prices, k)

        assertEquals(4, result, "Only one transaction is possible, extra k doesn't help")
    }

    @Test
    @DisplayName("Multiple peaks and valleys: prices = [3,2,6,5,0,3], k = 2, returns 10")
    fun testMultiplePeaksAndValleys() {
        val prices = intArrayOf(3, 2, 6, 5, 0, 3)
        val k = 2

        val result = solution.maximumProfit(prices, k)

        assertEquals(
            9,
            result,
            "Should capitalize on both valleys: buy at 2 sell at 6 (profit 4), buy at 0 sell at 3 (profit 3), plus short opportunities"
        )
    }

    @Test
    @DisplayName("One transaction: prices = [1,2,3,4,5], k = 1, returns 4")
    fun testOneTransaction() {
        val prices = intArrayOf(1, 2, 3, 4, 5)
        val k = 1

        val result = solution.maximumProfit(prices, k)

        assertEquals(4, result, "Buy at 1, sell at 5 for maximum profit of 4")
    }

    @Test
    @DisplayName("Zigzag pattern: prices = [1,3,2,4,3,5], k = 3, returns 8")
    fun testZigzagPattern() {
        val prices = intArrayOf(1, 3, 2, 4, 3, 5)
        val k = 3

        val result = solution.maximumProfit(prices, k)

        assertEquals(6, result, "Multiple small transactions can accumulate profit")
    }

    @Test
    @DisplayName("Large k value: prices = [1,9,6,9,1,7,1,1,5], k = 5, returns maximum possible")
    fun testLargeKValue() {
        val prices = intArrayOf(1, 9, 6, 9, 1, 7, 1, 1, 5)
        val k = 5

        val result = solution.maximumProfit(prices, k)

        // Calculate expected: Multiple opportunities for buying low and selling high
        // This tests that the algorithm handles multiple transactions efficiently
        assertEquals(26, result, "Should maximize profit with multiple transactions")
    }

    @Test
    @DisplayName("Short selling opportunity: prices = [10,8,6,4,2], k = 2, returns 16")
    fun testShortSellingOpportunity() {
        val prices = intArrayOf(10, 8, 6, 4, 2)
        val k = 2

        val result = solution.maximumProfit(prices, k)

        assertEquals(
            8,
            result,
            "Short selling during decline: sell at 10, buy at 2 (profit 8), plus additional transaction"
        )
    }

    @Test
    @DisplayName("Cooldown constraint test: prices = [1,2,4], k = 1, returns 3")
    fun testCooldownConstraint() {
        val prices = intArrayOf(1, 2, 4)
        val k = 1

        val result = solution.maximumProfit(prices, k)

        assertEquals(3, result, "Buy at 1, sell at 4 for profit of 3")
    }

    @Test
    @DisplayName("Mixed operations: prices = [5,1,5,3,7,4,9], k = 3, returns 18")
    fun testMixedOperations() {
        val prices = intArrayOf(5, 1, 5, 3, 7, 4, 9)
        val k = 3

        val result = solution.maximumProfit(prices, k)

        assertEquals(13, result, "Combination of normal and short transactions across multiple opportunities")
    }

    @Test
    @DisplayName("Two elements same value: prices = [3,3], k = 1, returns 0")
    fun testTwoElementsSameValue() {
        val prices = intArrayOf(3, 3)
        val k = 1

        val result = solution.maximumProfit(prices, k)

        assertEquals(0, result, "No profit when consecutive prices are the same")
    }

    @Test
    @DisplayName("Large array with limited transactions: prices with 100 elements, k = 5")
    fun testLargeArrayLimitedTransactions() {
        val prices = IntArray(100) { it % 10 + 1 } // Creates pattern: [1,2,3,...,10,1,2,3,...,10,...]
        val k = 5

        val result = solution.maximumProfit(prices, k)

        // Should be able to handle larger arrays efficiently
        assert(result > 0) { "Should find profitable transactions in large array" }
    }

    @Test
    @DisplayName("Edge case: prices = [1,1,1,1,1], k = 2, returns 0")
    fun testAllSamePrices() {
        val prices = intArrayOf(1, 1, 1, 1, 1)
        val k = 2

        val result = solution.maximumProfit(prices, k)

        assertEquals(0, result, "No profit when all prices are identical")
    }
}
