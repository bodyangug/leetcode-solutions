package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/magic-squares-in-grid
class MagicSquaresInGrid {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        var ans = 0
        val m = grid.size
        val n = grid[0].size
        var row = 0
        while (row + 2 < m) {
            var col = 0
            while (col + 2 < n) {
                if (isMagicSquare(grid, row, col)) {
                    ans++
                }
                col++
            }
            row++
        }
        return ans
    }

    private fun isMagicSquare(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        val sequence = "2943816729438167"
        val sequenceReversed = "7618349276183492"

        val border = StringBuilder()
        val borderIndices = intArrayOf(0, 1, 2, 5, 8, 7, 6, 3)
        for (i in borderIndices) {
            val num = grid[row + i / 3][col + (i % 3)]
            border.append(num)
        }

        val borderConverted = border.toString()
        return (grid[row][col] % 2 == 0 &&
                (sequence.contains(borderConverted) ||
                        sequenceReversed.contains(borderConverted)) && grid[row + 1][col + 1] == 5
                )
    }
}