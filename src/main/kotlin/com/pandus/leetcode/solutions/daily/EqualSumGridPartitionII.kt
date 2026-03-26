package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/equal-sum-grid-partition-ii
class EqualSumGridPartitionII {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val total = grid.sumOf { row -> row.sumOf { it.toLong() } }
        var current = grid

        repeat(4) {
            val m = current.size
            val n = current[0].size

            if (m >= 2) {
                val exist = mutableSetOf(0L)
                var sum = 0L

                if (n == 1) {
                    for (i in 0 until m - 1) {
                        sum += current[i][0]
                        val tag = sum * 2 - total
                        if (tag == 0L || tag == current[0][0].toLong() || tag == current[i][0].toLong()) {
                            return true
                        }
                    }
                } else {
                    for (i in 0 until m - 1) {
                        for (j in 0 until n) {
                            exist.add(current[i][j].toLong())
                            sum += current[i][j]
                        }
                        val tag = sum * 2 - total
                        if (i == 0) {
                            if (tag == 0L || tag == current[0][0].toLong() || tag == current[0][n - 1].toLong()) {
                                return true
                            }
                        } else if (exist.contains(tag)) {
                            return true
                        }
                    }
                }
            }

            current = rotation(current)
        }

        return false
    }

    private fun rotation(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        return Array(n) { j -> IntArray(m) { i -> grid[m - 1 - i][j] } }
    }
}
