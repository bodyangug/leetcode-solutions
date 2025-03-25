package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections
class CheckIfGridCanBeCutIntoSections {
    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1)
    }

    private fun checkCuts(rectangles: Array<IntArray>, dim: Int): Boolean {
        var gapCount = 0

        val sorted = rectangles.sortedBy { it[dim] }
        var furthestEnd = sorted[0][dim + 2]

        for (i in 1 until sorted.size) {
            val rect = sorted[i]
            if (furthestEnd <= rect[dim]) {
                gapCount++
            }
            furthestEnd = maxOf(furthestEnd, rect[dim + 2])
        }

        return gapCount >= 2
    }
}
