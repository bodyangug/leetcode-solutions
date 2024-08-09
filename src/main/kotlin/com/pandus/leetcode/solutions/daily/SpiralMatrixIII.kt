package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/spiral-matrix-iii
class SpiralMatrixIII {
    fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
        // Store all possible directions in an array.
        var rStart = rStart
        var cStart = cStart
        val dir = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val traversed = Array(rows * cols) { IntArray(2) }
        var idx = 0

        // Initial step size is 1, value of d represents the current direction.
        var step = 1
        var direction = 0
        while (idx < rows * cols) {
            // direction = 0 -> East, direction = 1 -> South
            // direction = 2 -> West, direction = 3 -> North
            for (i in 0..1) {
                for (j in 0 until step) {
                    // Validate the current position
                    if (rStart in 0..<rows && cStart >= 0 && cStart < cols
                    ) {
                        traversed[idx][0] = rStart
                        traversed[idx][1] = cStart
                        ++idx
                    }
                    // Make changes to the current position.
                    rStart += dir[direction][0]
                    cStart += dir[direction][1]
                }

                direction = (direction + 1) % 4
            }
            ++step
        }
        return traversed
    }
}