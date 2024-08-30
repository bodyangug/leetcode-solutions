package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

// Reference: https://leetcode.com/problems/minimum-cost-to-hire-k-workers
class MinimumCostToHireKWorkers {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val n = quality.size
        var totalCost = Double.MAX_VALUE
        var currentTotalQuality = 0.0
        val wageToQualityRatio = ArrayList<Pair<Double, Int>>()

        // Calculate wage-to-quality ratio for each worker
        for (i in 0 until n) {
            wageToQualityRatio.add(Pair(wage[i].toDouble() / quality[i], quality[i]))
        }

        // Sort workers based on their wage-to-quality ratio
        wageToQualityRatio.sortBy { it.first }

        // Use a priority queue to keep track of the highest quality workers
        val highestQualityWorkers = PriorityQueue<Int>(compareByDescending { it })

        // Iterate through workers
        for (i in 0 until n) {
            highestQualityWorkers.add(wageToQualityRatio[i].second)
            currentTotalQuality += wageToQualityRatio[i].second

            // If we have more than k workers,
            // remove the one with the highest quality
            if (highestQualityWorkers.size > k) {
                currentTotalQuality -= highestQualityWorkers.poll()
            }

            // If we have exactly k workers,
            // calculate the total cost and update if it's the minimum
            if (highestQualityWorkers.size == k) {
                totalCost = minOf(totalCost, currentTotalQuality * wageToQualityRatio[i].first)
            }
        }
        return totalCost
    }
}
