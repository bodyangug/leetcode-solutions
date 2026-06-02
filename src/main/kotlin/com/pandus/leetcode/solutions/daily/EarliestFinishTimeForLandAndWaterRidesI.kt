package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i
class EarliestFinishTimeForLandAndWaterRidesI {
    fun earliestFinishTime(
        landStartTime: IntArray,
        landDuration: IntArray,
        waterStartTime: IntArray,
        waterDuration: IntArray
    ): Int {
        val n = landStartTime.size
        val m = waterStartTime.size

        val minLandEnd = (0 until n).minOf { landStartTime[it] + landDuration[it] }
        val minWaterEnd = (0 until m).minOf { waterStartTime[it] + waterDuration[it] }

        // Option 1: land first, then water
        val option1 = (0 until m).minOf { j ->
            maxOf(minLandEnd, waterStartTime[j]) + waterDuration[j]
        }

        // Option 2: water first, then land
        val option2 = (0 until n).minOf { i ->
            maxOf(minWaterEnd, landStartTime[i]) + landDuration[i]
        }

        return minOf(option1, option2)
    }
}
