package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop
class FinalPricesWithSpecialDiscountInShop {
    fun finalPrices(prices: IntArray): IntArray {
        for (i in prices.indices) {
            for (j in i + 1 until prices.size) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j]
                    break
                }
            }
        }
        return prices
    }
}
