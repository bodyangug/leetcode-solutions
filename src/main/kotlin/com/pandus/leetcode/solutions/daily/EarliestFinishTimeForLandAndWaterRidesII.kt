package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii
class EarliestFinishTimeForLandAndWaterRidesII {
    fun earliestFinishTime(
        landStartTime: IntArray,
        landDuration: IntArray,
        waterStartTime: IntArray,
        waterDuration: IntArray
    ): Int {
        // Find the land ride that finishes earliest
        var minLandFinish = Int.MAX_VALUE
        for (i in landStartTime.indices) {
            minLandFinish = minOf(minLandFinish, landStartTime[i] + landDuration[i])
        }
        // Find the water ride that finishes earliest
        var minWaterFinish = Int.MAX_VALUE
        for (j in waterStartTime.indices) {
            minWaterFinish = minOf(minWaterFinish, waterStartTime[j] + waterDuration[j])
        }

        var result = Int.MAX_VALUE
        // Option 1: Do land first (best land ride), then each water ride
        for (j in waterStartTime.indices) {
            val startWater = maxOf(minLandFinish, waterStartTime[j])
            result = minOf(result, startWater + waterDuration[j])
        }
        // Option 2: Do water first (best water ride), then each land ride
        for (i in landStartTime.indices) {
            val startLand = maxOf(minWaterFinish, landStartTime[i])
            result = minOf(result, startLand + landDuration[i])
        }
        return result
    }
}
