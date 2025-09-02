package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i
class FindTheNumberOfWaysToPlacePeopleI {
    fun numberOfPairs(points: Array<IntArray>): Int {
        var ans = 0
        val n = points.size

        for (i in 0..<n) {
            val pointA = points[i]
            for (j in 0..<n) {
                val pointB = points[j]
                if (i == j ||
                    !(pointA[0] <= pointB[0] && pointA[1] >= pointB[1])
                ) {
                    continue
                }
                if (n == 2) {
                    ans++
                    continue
                }

                var illegal = false
                for (k in 0..<n) {
                    if (k == i || k == j) {
                        continue
                    }

                    val pointTmp = points[k]
                    val isXContained =
                        pointTmp[0] >= pointA[0] && pointTmp[0] <= pointB[0]
                    val isYContained =
                        pointTmp[1] <= pointA[1] && pointTmp[1] >= pointB[1]
                    if (isXContained && isYContained) {
                        illegal = true
                        break
                    }
                }
                if (!illegal) {
                    ans++
                }
            }
        }
        return ans
    }
}
