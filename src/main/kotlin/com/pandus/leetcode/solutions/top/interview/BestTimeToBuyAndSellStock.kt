package com.pandus.leetcode.solutions.top.interview

class BestTimeToBuyAndSellStock {

    //Brute-force solution
    fun maxProfit1(prices: IntArray): Int {
        var maxProfit = 0
        val n = prices.size
        for (current in 0 until n) {
            for (futureDay in current + 1 until n) {
                val curPrice = prices[current]
                val nextPrice = prices[futureDay]
                if (curPrice < nextPrice) {
                    val tempProfit = nextPrice - curPrice
                    if (tempProfit > maxProfit) {
                        maxProfit = tempProfit
                    }
                }
            }
        }
        return maxProfit
    }


    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minPrice = Int.MAX_VALUE

        for (price in prices) {
            minPrice = minOf(minPrice, price)
            maxProfit = maxOf(maxProfit, price - minPrice)
        }
        return maxProfit
    }
}
