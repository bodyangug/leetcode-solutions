package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-a-safe-walk-through-a-grid
class FindSafeWalkThroughGrid {
    // 0-1 BFS: cost of entering a cell is grid[i][j] (0 or 1).
    // Compute the minimum health lost to reach the bottom-right corner,
    // then verify the remaining health stays positive.
    fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
        val rows = grid.size
        val cols = grid[0].size

        val cost = Array(rows) { IntArray(cols) { _ -> Int.MAX_VALUE } }
        val deque = ArrayDeque<IntArray>()
        val startCost = grid[0][0]
        cost[0][0] = startCost
        deque.addFirst(intArrayOf(0, 0))

        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()
            val row = current[0]
            val col = current[1]
            val curCost = cost[row][col]

            for (dir in directions) {
                val newRow = row + dir[0]
                val newCol = col + dir[1]
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                    continue
                }

                val weight = grid[newRow][newCol]
                val newCost = curCost + weight
                if (newCost < cost[newRow][newCol]) {
                    cost[newRow][newCol] = newCost
                    if (weight == 0) {
                        deque.addFirst(intArrayOf(newRow, newCol))
                    } else {
                        deque.addLast(intArrayOf(newRow, newCol))
                    }
                }
            }
        }
        return health - cost[rows - 1][cols - 1] >= 1
    }
}
