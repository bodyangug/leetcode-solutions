package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-ice-cream-bars
class MaximumIceCreamBars {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        val count = IntArray(100001)
        for (cost in costs) {
            count[cost]++
        }
        var result = 0
        var remainingCoins = coins
        for (i in count.indices) {
            if (count[i] > 0) {
                val maxBars = remainingCoins / i
                val barsToBuy = minOf(maxBars, count[i])
                result += barsToBuy
                remainingCoins -= barsToBuy * i
            }
        }
        return result
    }
}
