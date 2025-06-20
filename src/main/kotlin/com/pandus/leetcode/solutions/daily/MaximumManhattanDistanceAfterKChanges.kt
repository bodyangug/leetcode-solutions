package com.pandus.leetcode.solutions.daily

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes
class MaximumManhattanDistanceAfterKChanges {
    fun maxDistance(s: String, k: Int): Int {
        var maxDistance = 0
        val directionCount = mutableMapOf(
            'N' to 0,
            'S' to 0,
            'E' to 0,
            'W' to 0
        )

        for (dir in s) {
            directionCount[dir] = directionCount.getValue(dir) + 1

            val verticalModifications = min(min(directionCount['N']!!, directionCount['S']!!), k)
            val horizontalModifications = min(
                min(directionCount['E']!!, directionCount['W']!!),
                k - verticalModifications
            )

            val verticalDistance = calculateDistance(
                directionCount['N']!!,
                directionCount['S']!!,
                verticalModifications
            )
            val horizontalDistance = calculateDistance(
                directionCount['E']!!,
                directionCount['W']!!,
                horizontalModifications
            )

            maxDistance = max(maxDistance, verticalDistance + horizontalDistance)
        }

        return maxDistance
    }

    private fun calculateDistance(
        countA: Int,
        countB: Int,
        modifications: Int
    ): Int {
        return abs(countA - countB) + modifications * 2
    }
}
