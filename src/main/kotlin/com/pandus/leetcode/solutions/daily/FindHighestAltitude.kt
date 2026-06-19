package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-highest-altitude
class FindHighestAltitude {
    fun largestAltitude(gain: IntArray): Int {
        var maxAltitude = 0
        var currentAltitude = 0

        for (g in gain) {
            currentAltitude += g
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude
            }
        }
        return maxAltitude
    }
}
