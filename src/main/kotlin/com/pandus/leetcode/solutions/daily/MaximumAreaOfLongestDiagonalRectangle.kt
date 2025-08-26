package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle
class MaximumAreaOfLongestDiagonalRectangle {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var bestDia = -1L
        var bestArea = 0L

        for (i in dimensions.indices) {
            val box = dimensions[i]
            val l = box[0]
            val w = box[1]

            val dia = l.toLong() * l + w.toLong() * w
            val area = l.toLong() * w

            if (dia > bestDia || (dia == bestDia && area > bestArea)) {
                bestDia = dia
                bestArea = area
            }
        }
        return bestArea.toInt()
    }
}
