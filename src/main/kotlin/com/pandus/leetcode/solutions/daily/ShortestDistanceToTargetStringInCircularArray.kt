package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array
class ShortestDistanceToTargetStringInCircularArray {
    fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
        var ans = Int.MAX_VALUE
        for (i in words.indices) {
            if (words[i] == target) {
                val directDistance = abs(i - startIndex)
                val circularDistance = words.size - directDistance
                ans = minOf(ans, minOf(directDistance, circularDistance))
            }
        }
        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}
