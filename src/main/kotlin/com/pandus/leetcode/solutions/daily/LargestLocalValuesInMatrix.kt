package com.pandus.leetcode.solutions.daily

import kotlin.math.max

//Reference: https://leetcode.com/problems/largest-local-values-in-a-matrix
class LargestLocalValuesInMatrix {
    private fun findMax(grid: Array<IntArray>, x: Int, y: Int): Int {
        var maxElement = 0
        for (i in x until x + 3) {
            for (j in y until y + 3) {
                maxElement = max(maxElement, grid[i][j])
            }
        }
        return maxElement
    }

    fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val N = grid.size
        val maxLocal = Array(N - 2) { IntArray(N - 2) }
        for (i in 0 until N - 2) {
            for (j in 0 until N - 2) {
                maxLocal[i][j] = findMax(grid, i, j)
            }
        }
        return maxLocal
    }
}