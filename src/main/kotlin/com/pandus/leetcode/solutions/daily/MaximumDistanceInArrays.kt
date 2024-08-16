package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

//Reference: https://leetcode.com/problems/maximum-distance-in-arrays
class MaximumDistanceInArrays {
    fun maxDistance(arrays: List<List<Int>>): Int {
        var maxDist = 0
        var currentMin = arrays[0].first()
        var currentMax = arrays[0].last()

        for (i in 1 until arrays.size) {
            val first = arrays[i].first()
            val last = arrays[i].last()

            // Calculate distances using the current array's first and last elements
            maxDist = maxOf(maxDist, abs(last - currentMin))
            maxDist = maxOf(maxDist, abs(currentMax - first))

            // Update current min and max
            currentMin = minOf(currentMin, first)
            currentMax = maxOf(currentMax, last)
        }

        return maxDist
    }
}
