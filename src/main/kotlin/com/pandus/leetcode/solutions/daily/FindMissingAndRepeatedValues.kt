package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-missing-and-repeated-values
class FindMissingAndRepeatedValues {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size
        val count = IntArray(n * n + 1)
        var missing = -1
        var repeat = -1

        // Count occurrences of each number in grid
        for (row in grid) {
            for (num in row) {
                count[num]++
            }
        }

        // Identify the missing and repeated number
        for (num in 1..n * n) {
            when (count[num]) {
                0 -> missing = num // Missing number
                2 -> repeat = num // Repeated number
            }
        }
        return intArrayOf(repeat, missing)
    }
}
