package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/pacific-atlantic-water-flow
class PacificAtlanticWaterFlow {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        if (heights.isEmpty() || heights[0].isEmpty()) return emptyList()

        val m = heights.size
        val n = heights[0].size

        val canReachPacific = Array(m) { BooleanArray(n) }
        val canReachAtlantic = Array(m) { BooleanArray(n) }

        // Direction vectors for north, south, east, west
        val directions = arrayOf(
            intArrayOf(-1, 0), // north
            intArrayOf(1, 0),  // south
            intArrayOf(0, 1),  // east
            intArrayOf(0, -1)  // west
        )

        fun dfs(row: Int, col: Int, visited: Array<BooleanArray>) {
            visited[row][col] = true

            for (dir in directions) {
                val newRow = row + dir[0]
                val newCol = col + dir[1]

                // Check bounds and if already visited
                if (newRow in 0 until m &&
                    newCol in 0 until n &&
                    !visited[newRow][newCol] &&
                    heights[newRow][newCol] >= heights[row][col]
                ) {
                    dfs(newRow, newCol, visited)
                }
            }
        }

        // Start DFS from Pacific borders (top row and left column)
        for (i in 0 until m) {
            dfs(i, 0, canReachPacific) // left column
        }
        for (j in 0 until n) {
            dfs(0, j, canReachPacific) // top row
        }

        // Start DFS from Atlantic borders (bottom row and right column)
        for (i in 0 until m) {
            dfs(i, n - 1, canReachAtlantic) // right column
        }
        for (j in 0 until n) {
            dfs(m - 1, j, canReachAtlantic) // bottom row
        }

        // Find cells that can reach both oceans
        val result = mutableListOf<List<Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }
}
