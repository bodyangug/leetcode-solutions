package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii
class FindNumberOfWaysToPlacePeopleII {
    fun numberOfPairs(points: Array<IntArray>): Int {
        points.sortWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })

        var ans = 0
        val n = points.size

        for (i in 0 until n - 1) {
            val yCap = points[i][1]
            var yMin = Int.MIN_VALUE

            for (j in i + 1 until n) {
                val y = points[j][1]
                if (y > yMin && y <= yCap) {
                    ans++
                    yMin = y
                    if (yMin == yCap) break
                }
            }
        }
        return ans
    }
}
