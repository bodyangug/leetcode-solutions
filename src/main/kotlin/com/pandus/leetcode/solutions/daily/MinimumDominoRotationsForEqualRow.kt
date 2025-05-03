package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row
class MinimumDominoRotationsForEqualRow {
    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        fun check(x: Int): Int {
            var rotationsTop = 0
            var rotationsBottom = 0
            for (i in tops.indices) {
                if (tops[i] != x && bottoms[i] != x) {
                    return -1 // Impossible to make all tops or bottoms == x
                } else if (tops[i] != x) {
                    rotationsTop++ // need to rotate top to bottom
                } else if (bottoms[i] != x) {
                    rotationsBottom++ // need to rotate bottom to top
                }
            }
            return minOf(rotationsTop, rotationsBottom)
        }

        val res1 = check(tops[0])
        if (res1 != -1) return res1
        // If tops[0] failed, try bottoms[0] (but only if it's different)
        return if (tops[0] != bottoms[0]) check(bottoms[0]) else -1
    }
}
