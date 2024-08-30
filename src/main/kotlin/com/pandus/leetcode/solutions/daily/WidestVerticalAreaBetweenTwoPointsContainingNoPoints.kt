package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points
class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        val sorted = points.map { it.first() }.sorted()
        var maxDistance = -1
        for (i in sorted.withIndex()) {
            if (i.index + 1 == sorted.size - 1) break
            if (sorted[i.index + 1] - i.value > maxDistance) {
                maxDistance = sorted[i.index + 1] - i.value
            }
        }
        return maxDistance
    }
}
