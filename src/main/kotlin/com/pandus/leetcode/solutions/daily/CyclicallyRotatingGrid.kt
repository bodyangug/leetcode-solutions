package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/cyclically-rotating-a-grid
class CyclicallyRotatingGrid {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val layers = m.coerceAtMost(n) / 2
        for (i in 0 until layers) {
            val layerElements = mutableListOf<Int>()
            // top row
            for (j in i until n - i) {
                layerElements.add(grid[i][j])
            }
            // right column
            for (j in i + 1 until m - i - 1) {
                layerElements.add(grid[j][n - i - 1])
            }
            // bottom row
            for (j in n - i - 1 downTo i) {
                layerElements.add(grid[m - i - 1][j])
            }
            // left column
            for (j in m - i - 2 downTo i + 1) {
                layerElements.add(grid[j][i])
            }
            val rotation = k % layerElements.size
            val rotatedLayer = layerElements.drop(rotation) + layerElements.take(rotation)
            var index = 0
            // top row
            for (j in i until n - i) {
                grid[i][j] = rotatedLayer[index++]
            }
            // right column
            for (j in i + 1 until m - i - 1) {
                grid[j][n - i - 1] = rotatedLayer[index++]
            }
            // bottom row
            for (j in n - i - 1 downTo i) {
                grid[m - i - 1][j] = rotatedLayer[index++]
            }
            // left column
            for (j in m - i - 2 downTo i + 1) {
                grid[j][i] = rotatedLayer[index++]
            }
        }
        return grid
    }
}
