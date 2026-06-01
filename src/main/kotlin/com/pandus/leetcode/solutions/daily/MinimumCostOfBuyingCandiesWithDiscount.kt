package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount
class MinimumCostOfBuyingCandiesWithDiscount {
    fun minimumCost(cost: IntArray): Int {
        cost.sort()
        var totalCost = 0
        for (i in cost.size - 1 downTo 0 step 3) {
            totalCost += cost[i]
            if (i - 1 >= 0) {
                totalCost += cost[i - 1]
            }
        }
        return totalCost
    }
}
