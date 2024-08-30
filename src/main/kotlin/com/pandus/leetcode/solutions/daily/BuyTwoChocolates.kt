package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/buy-two-chocolates
class BuyTwoChocolates {
    fun buyChoco(prices: IntArray, money: Int): Int {
        val resultList = ArrayList<Pair<Int, Int>>()
        for (i in prices.withIndex()) {
            for (j in prices.withIndex().drop(i.index + 1)) {
                if ((i.value + j.value) <= money) {
                    resultList.add(Pair(i.value, j.value))
                }
            }
        }

        return if (resultList.isNotEmpty()) {
            val minOf = resultList.minOf { it.first + it.second }
            money - minOf
        } else {
            money
        }
    }
}
