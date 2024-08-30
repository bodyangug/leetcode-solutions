package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/water-bottles
class WaterBottles {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var numBottles = numBottles
        var consumedBottles = 0

        while (numBottles >= numExchange) {
            consumedBottles += numExchange
            numBottles -= numExchange
            numBottles++
        }
        return consumedBottles + numBottles
    }
}
