package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/maximum-building-height
class MaximumBuildingHeight {
    fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
        val sortedRestrictions = restrictions.sortedBy { it[0] }.toMutableList()
        if (sortedRestrictions.isEmpty() || sortedRestrictions[0][0] != 1) {
            sortedRestrictions.add(0, intArrayOf(1, 0))
        }
        if (sortedRestrictions.last()[0] != n) {
            sortedRestrictions.add(intArrayOf(n, n - 1))
        }

        for (i in 1 until sortedRestrictions.size) {
            val prev = sortedRestrictions[i - 1]
            val curr = sortedRestrictions[i]
            val maxHeight = prev[1] + (curr[0] - prev[0])
            if (curr[1] > maxHeight) {
                curr[1] = maxHeight
            }
        }

        for (i in sortedRestrictions.size - 2 downTo 0) {
            val next = sortedRestrictions[i + 1]
            val curr = sortedRestrictions[i]
            val maxHeight = next[1] + (next[0] - curr[0])
            if (curr[1] > maxHeight) {
                curr[1] = maxHeight
            }
        }

        var maxBuildingHeight = 0
        for (i in 1 until sortedRestrictions.size) {
            val prev = sortedRestrictions[i - 1]
            val curr = sortedRestrictions[i]
            val distance = curr[0] - prev[0]
            val heightDiff = abs(curr[1] - prev[1])
            if (distance >= heightDiff) {
                val possibleMaxHeight = maxOf(curr[1], prev[1]) + (distance - heightDiff) / 2
                maxBuildingHeight = maxOf(maxBuildingHeight, possibleMaxHeight)
            } else {
                maxBuildingHeight = maxOf(maxBuildingHeight, maxOf(curr[1], prev[1]) + distance)
            }
        }
        return maxBuildingHeight
    }
}
