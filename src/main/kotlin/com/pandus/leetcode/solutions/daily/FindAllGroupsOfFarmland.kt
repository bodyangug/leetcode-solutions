package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-all-groups-of-farmland
class FindAllGroupsOfFarmland {
    // The four directions in which traversal will be done.
    val dirs = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(1, 0)
    )

    // Global variables with 0 value initially.
    var row2 = 0
    var col2 = 0

    // Returns true if the coordinate is within the boundary of the matrix.
    private fun isWithinFarm(x: Int, y: Int, N: Int, M: Int): Boolean {
        return x >= 0 && x < N && y >= 0 && y < M
    }

    private fun dfs(land: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int) {
        visited[x][y] = true
        // Maximum x and y for the bottom right cell.
        row2 = maxOf(row2, x)
        col2 = maxOf(col2, y)

        for (dir in dirs) {
            // Neighbor cell coordinates.
            val newX = x + dir[0]
            val newY = y + dir[1]

            // If the neighbor is within the matrix and is a farmland cell and is not visited yet.
            if (isWithinFarm(newX, newY, land.size, land[0].size) &&
                !visited[newX][newY] &&
                land[newX][newY] == 1
            ) {
                dfs(land, visited, newX, newY)
            }
        }
    }

    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val visited = Array(land.size) { BooleanArray(land[0].size) }
        val ans = mutableListOf<IntArray>()

        for (row1 in land.indices) {
            for (col1 in land[0].indices) {
                if (land[row1][col1] == 1 && !visited[row1][col1]) {
                    row2 = 0
                    col2 = 0

                    dfs(land, visited, row1, col1)

                    val arr = intArrayOf(row1, col1, row2, col2)
                    ans.add(arr)
                }
            }
        }
        return ans.toTypedArray()
    }
}
