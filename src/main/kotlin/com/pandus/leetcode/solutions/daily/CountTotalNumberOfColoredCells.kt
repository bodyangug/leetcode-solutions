package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-total-number-of-colored-cells
class CountTotalNumberOfColoredCells {
    fun coloredCells(n: Int): Long {
        return 1 + n.toLong() * (n - 1) * 2
    }
}
