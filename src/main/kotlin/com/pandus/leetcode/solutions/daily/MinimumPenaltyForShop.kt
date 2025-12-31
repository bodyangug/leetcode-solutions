package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-penalty-for-a-shop
class MinimumPenaltyForShop {
    fun bestClosingTime(customers: String): Int {
        var currentPenalty = customers.count { it == 'Y' }
        var minPenalty = currentPenalty
        var bestHour = 0
        for (i in customers.indices) {
            if (customers[i] == 'Y') {
                currentPenalty--
            } else {
                currentPenalty++
            }

            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty
                bestHour = i + 1
            }
        }
        return bestHour
    }
}
