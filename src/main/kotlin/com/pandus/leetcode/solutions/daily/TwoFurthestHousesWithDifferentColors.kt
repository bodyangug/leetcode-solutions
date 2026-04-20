package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/two-furthest-houses-with-different-colors
class TwoFurthestHousesWithDifferentColors {
    fun maxDistance(colors: IntArray): Int {
        val n = colors.size
        var result = 0
        for (i in n - 1 downTo 1) {
            if (colors[i] != colors[0]) {
                result = maxOf(result, i)
                break
            }
        }
        for (i in 0 until n - 1) {
            if (colors[i] != colors[n - 1]) {
                result = maxOf(result, n - 1 - i)
                break
            }
        }
        return result
    }
}
