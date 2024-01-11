package com.pandus.leetcode.solutions.weekly

import kotlin.math.min

//Reference: https://leetcode.com/problems/leftmost-column-with-at-least-a-one
class LeftmostColumnWithAtLeastOne {
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val rows = binaryMatrix.dimensions()[0]
        val cols = binaryMatrix.dimensions()[1]
        var smallestIndex = cols
        for (row in 0..<rows) {
            var lo = 0
            var hi = cols - 1
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (binaryMatrix.get(row, mid) == 0) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }

            if (binaryMatrix.get(row, lo) == 1) {
                smallestIndex = min(smallestIndex, lo)
            }
        }
        return if (smallestIndex == cols) -1 else smallestIndex
    }
}

class BinaryMatrix {
    fun get(row: Int, col: Int): Int {
        return 0
    }

    fun dimensions(): List<Int> {
        return emptyList()
    }
}