package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v
class BestTimeToBuyAndSellStockV {
    private lateinit var prices: IntArray
    private lateinit var memo: Array<Array<LongArray>>

    private companion object {
        const val IDLE = 0
        const val HOLDING = 1
        const val COOLDOWN = 2
        const val NOT_COMPUTED = -1L
    }

    fun maximumProfit(prices: IntArray, k: Int): Long {
        this.prices = prices
        val days = prices.size
        memo = Array(days) { Array(k + 1) { LongArray(3) { NOT_COMPUTED } } }
        return calculateMaxProfit(day = days - 1, transactionsRemaining = k, state = IDLE)
    }

    private fun calculateMaxProfit(day: Int, transactionsRemaining: Int, state: Int): Long {
        if (transactionsRemaining == 0) {
            return 0
        }
        if (day == 0) {
            return getFirstDayProfit(state)
        }

        if (memo[day][transactionsRemaining][state] != NOT_COMPUTED) {
            return memo[day][transactionsRemaining][state]
        }

        val currentPrice = prices[day]
        val result = when (state) {
            IDLE -> calculateIdleStateProfit(day, transactionsRemaining, currentPrice)
            HOLDING -> calculateHoldingStateProfit(day, transactionsRemaining, currentPrice)
            COOLDOWN -> calculateCooldownStateProfit(day, transactionsRemaining, currentPrice)
            else -> 0L
        }
        memo[day][transactionsRemaining][state] = result
        return result
    }

    private fun getFirstDayProfit(state: Int): Long {
        return when (state) {
            IDLE -> 0L
            HOLDING -> -prices[0].toLong()
            COOLDOWN -> prices[0].toLong()
            else -> 0L
        }
    }

    private fun calculateIdleStateProfit(day: Int, transactionsRemaining: Int, currentPrice: Int): Long {
        val stayIdle = calculateMaxProfit(day - 1, transactionsRemaining, IDLE)
        val exitHolding = calculateMaxProfit(day - 1, transactionsRemaining, HOLDING) + currentPrice
        val exitCooldown = calculateMaxProfit(day - 1, transactionsRemaining, COOLDOWN) - currentPrice
        return max(stayIdle, max(exitHolding, exitCooldown))
    }

    private fun calculateHoldingStateProfit(day: Int, transactionsRemaining: Int, currentPrice: Int): Long {
        val continueHolding = calculateMaxProfit(day - 1, transactionsRemaining, HOLDING)
        val buyStock = calculateMaxProfit(day - 1, transactionsRemaining - 1, IDLE) - currentPrice
        return max(continueHolding, buyStock)
    }

    private fun calculateCooldownStateProfit(day: Int, transactionsRemaining: Int, currentPrice: Int): Long {
        val continueCooldown = calculateMaxProfit(day - 1, transactionsRemaining, COOLDOWN)
        val sellStock = calculateMaxProfit(day - 1, transactionsRemaining - 1, IDLE) + currentPrice
        return max(continueCooldown, sellStock)
    }
}
