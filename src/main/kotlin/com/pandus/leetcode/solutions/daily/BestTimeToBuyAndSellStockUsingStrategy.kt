package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy
class BestTimeToBuyAndSellStockUsingStrategy {
    fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
        val prefixProfits = calculatePrefixProfits(prices, strategy)
        val prefixPrices = calculatePrefixPrices(prices)

        var maxProfit = prefixProfits.last()

        for (windowEnd in k - 1 until prices.size) {
            val totalProfitWithStrategyChange = calculateProfitWithStrategyChange(
                windowEnd = windowEnd,
                windowSize = k,
                prefixProfits = prefixProfits,
                prefixPrices = prefixPrices
            )
            maxProfit = max(maxProfit, totalProfitWithStrategyChange)
        }

        return maxProfit
    }

    private fun calculatePrefixProfits(prices: IntArray, strategy: IntArray): LongArray {
        val size = prices.size
        val prefixProfits = LongArray(size + 1)

        for (i in prices.indices) {
            val currentProfit = prices[i].toLong() * strategy[i]
            prefixProfits[i + 1] = prefixProfits[i] + currentProfit
        }

        return prefixProfits
    }

    private fun calculatePrefixPrices(prices: IntArray): LongArray {
        val size = prices.size
        val prefixPrices = LongArray(size + 1)

        for (i in prices.indices) {
            prefixPrices[i + 1] = prefixPrices[i] + prices[i]
        }

        return prefixPrices
    }

    private fun calculateProfitWithStrategyChange(
        windowEnd: Int,
        windowSize: Int,
        prefixProfits: LongArray,
        prefixPrices: LongArray
    ): Long {
        val windowStart = windowEnd - windowSize + 1
        val windowMiddle = windowEnd - windowSize / 2 + 1

        val profitBeforeWindow = prefixProfits[windowStart]
        val profitAfterWindow = prefixProfits.last() - prefixProfits[windowEnd + 1]
        val profitFromStrategyChange = prefixPrices[windowEnd + 1] - prefixPrices[windowMiddle]

        return profitBeforeWindow + profitFromStrategyChange + profitAfterWindow
    }
}
