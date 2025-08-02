package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/rearranging-fruits
class RearrangingFruits {
    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        val freq = HashMap<Int, Int>()
        var minVal = Int.MAX_VALUE

        for (x in basket1) {
            freq[x] = freq.getOrDefault(x, 0) + 1
            if (x < minVal) minVal = x
        }
        for (x in basket2) {
            freq[x] = freq.getOrDefault(x, 0) - 1
            if (x < minVal) minVal = x
        }

        val excess = mutableListOf<Int>()
        for ((num, count) in freq) {
            if (count % 2 != 0) return -1
            repeat(kotlin.math.abs(count) / 2) {
                excess += num
            }
        }

        excess.sort()

        val swaps = excess.size / 2
        var cost = 0L
        for (i in 0 until swaps) {
            val value = excess[i]
            cost += minOf(value.toLong(), 2L * minVal)
        }
        return cost
    }
}
