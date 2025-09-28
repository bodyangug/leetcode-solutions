package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/largest-triangle-area
class LargestTriangleArea {
    fun largestTriangleArea(points: Array<IntArray>): Double {
        var max = 0.0
        for (i in points.indices)
            for (j in i + 1 until points.size)
                for (k in j + 1 until points.size) {
                    val (x1, y1) = points[i]
                    val (x2, y2) = points[j]
                    val (x3, y3) = points[k]
                    val area = kotlin.math.abs(
                        (x2 - x1) * (y3 - y1) -
                                (x3 - x1) * (y2 - y1)
                    ) * 0.5
                    max = maxOf(max, area)
                }
        return max
    }
}
