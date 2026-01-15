package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/maximize-area-of-square-hole-in-grid
class MaximizeAreaOfSquareHoleInGrid {
    fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
        val maxHorizontalConsecutive = findMaxConsecutiveCount(hBars)
        val maxVerticalConsecutive = findMaxConsecutiveCount(vBars)
        val sideLength = min(maxHorizontalConsecutive, maxVerticalConsecutive) + 1
        return sideLength * sideLength
    }

    private fun findMaxConsecutiveCount(bars: IntArray): Int {
        if (bars.isEmpty()) return 0

        bars.sort()

        var maxConsecutive = 1
        var currentConsecutive = 1

        for (i in 1 until bars.size) {
            if (bars[i] == bars[i - 1] + 1) {
                currentConsecutive++
                maxConsecutive = maxOf(maxConsecutive, currentConsecutive)
            } else {
                currentConsecutive = 1
            }
        }
        return maxConsecutive
    }
}
