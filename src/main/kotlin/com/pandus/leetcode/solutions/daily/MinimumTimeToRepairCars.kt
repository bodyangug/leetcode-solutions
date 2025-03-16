package com.pandus.leetcode.solutions.daily

import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/minimum-time-to-repair-cars
class MinimumTimeToRepairCars {
    fun repairCars(ranks: IntArray, cars: Int): Long {
        var minRank = Int.MAX_VALUE
        var maxRank = Int.MIN_VALUE

        // Find minRank, maxRank, and build frequency array in one pass
        val freq = IntArray(101) // ranks[i] ≤ 100 (based on problem constraints assumption)
        for (rank in ranks) {
            minRank = minOf(minRank, rank)
            maxRank = maxOf(maxRank, rank)
            freq[rank]++
        }

        var low = 1L
        var high = minRank.toLong() * cars * cars

        while (low < high) {
            val mid = (low + high) / 2
            var carsRepaired = 0L

            for (rank in 1..maxRank) {
                if (freq[rank] == 0) continue
                val canRepair = sqrt(mid.toDouble() / rank).toLong()
                carsRepaired += freq[rank] * canRepair
                if (carsRepaired >= cars) break // Early exit for efficiency
            }

            if (carsRepaired >= cars) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}
