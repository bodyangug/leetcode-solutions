package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/water-bottles-ii
class WaterBottlesII {
    fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
        var availableBottles = numBottles
        var changeRate = numExchange
        var emptyBottles = 0
        var drunkBottles = 0

        while (availableBottles > 0) {
            // Drink all current bottles
            drunkBottles += availableBottles
            emptyBottles += availableBottles
            availableBottles = 0

            // Exchange empty bottles for full ones
            while (emptyBottles >= changeRate) {
                availableBottles += if ((emptyBottles - changeRate) >= 0) 1 else 0
                emptyBottles -= changeRate
                changeRate += 1
            }
        }
        return drunkBottles
    }
}
