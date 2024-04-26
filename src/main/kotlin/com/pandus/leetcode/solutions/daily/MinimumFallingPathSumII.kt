package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/minimum-falling-path-sum-ii
class MinimumFallingPathSumII {
    fun minFallingPathSum(grid: Array<IntArray>): Int {
        val memo = Array(grid.size) { IntArray(grid[0].size) }

        //fill last row of memo with last row at grid
        val lastIndex = grid.size - 1
        memo[lastIndex] = grid[lastIndex]

        for (row in grid.withIndex().reversed()) {
            //check on last row
            if (row.index == 0) break

            //find first and second minimums with index
            var (indexOfFirstMin, valOfFirstMin) = Int.MAX_VALUE to Int.MAX_VALUE
            var valOfSecondMin = Int.MAX_VALUE

            //fill next row
            for ((index, value) in memo[row.index].withIndex()) {
                if (value < valOfFirstMin) {
                    valOfSecondMin = valOfFirstMin
                    valOfFirstMin = value
                    indexOfFirstMin = index
                } else if (value < valOfSecondMin && index != indexOfFirstMin) {
                    valOfSecondMin = value
                }

                if (index != indexOfFirstMin) {
                    memo[row.index - 1][index] = grid[row.index - 1][index] + valOfFirstMin
                }
            }

            memo[row.index - 1][indexOfFirstMin] = grid[row.index - 1][indexOfFirstMin] + valOfSecondMin
        }
        return memo[0].minOf { it }
    }

}
