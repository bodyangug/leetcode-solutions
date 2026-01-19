package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles
class FindLargestAreaOfSquareInsideTwoRectangles {
    fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
        val n = bottomLeft.size
        var maxSide: Long = 0
        for (i in 0..<n) {
            for (j in i + 1..<n) {
                val w =
                    min(topRight[i][0], topRight[j][0]) - max(bottomLeft[i][0], bottomLeft[j][0])
                val h =
                    min(topRight[i][1], topRight[j][1]) - max(bottomLeft[i][1], bottomLeft[j][1])
                val side = min(w, h)

                maxSide = max(maxSide, side.toLong())
            }
        }
        return maxSide * maxSide
    }
}
