package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-time-difference
class MinimumTimeDifference {
    fun findMinDifference(timePoints: List<String>): Int {
        val map = timePoints.map {
            val str = it.split(":")
            val hours = str[0].toInt()
            val minutes = str[1].toInt()
            (hours * 60) + minutes
        }.sorted()

        var minDiff = Int.MAX_VALUE
        for (i in 1 until map.size) {
            val diff = map[i] - map[i - 1]
            minDiff = minOf(minDiff, diff)
        }
        val wrapAroundDiff = (map[0] + 1440) - map[map.size - 1]
        minDiff = minOf(minDiff, wrapAroundDiff)
        return minDiff
    }
}
