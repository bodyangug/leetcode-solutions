package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
class MinimumNumberOfDaysToMakeMBouquets {
    private fun getNumOfBouquets(bloomDay: IntArray, mid: Int, k: Int): Int {
        var numOfBouquets = 0
        var count = 0
        for (i in bloomDay.indices) {
            // If the flower is bloomed, add to the set. Else reset the count.
            if (bloomDay[i] <= mid) {
                count++
            } else {
                count = 0
            }
            if (count == k) {
                numOfBouquets++
                count = 0
            }
        }
        return numOfBouquets
    }

    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        var start = 0
        var end = 0
        for (day in bloomDay) {
            end = max(end.toDouble(), day.toDouble()).toInt()
        }
        var minDays = -1
        while (start <= end) {
            val mid = (start + end) / 2
            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return minDays
    }
}
