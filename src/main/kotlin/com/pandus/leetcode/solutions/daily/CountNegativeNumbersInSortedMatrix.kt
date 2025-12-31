package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix
class CountNegativeNumbersInSortedMatrix {
    fun countNegatives(grid: Array<IntArray>): Int {
        var ans = 0
        for (i in grid.indices.reversed()) {
            for (j in grid[i].indices) {
                if (grid[i][j] < 0) ans++
            }
        }
        return ans
    }
}
