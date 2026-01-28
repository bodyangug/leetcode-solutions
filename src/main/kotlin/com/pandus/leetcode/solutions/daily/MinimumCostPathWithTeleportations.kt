package com.pandus.leetcode.solutions.daily

import java.util.*
import java.util.function.ToIntFunction
import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-cost-path-with-teleportations
class MinimumCostPathWithTeleportations {
    fun minCost(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val points: MutableList<IntArray> = ArrayList()
        for (i in 0..<m) {
            for (j in 0..<n) {
                points.add(intArrayOf(i, j))
            }
        }
        points.sortWith(Comparator.comparingInt(ToIntFunction { p: IntArray -> grid[p[0]][p[1]] }))
        val costs: Array<IntArray> = Array(m) { IntArray(n) }
        for (row in costs) {
            Arrays.fill(row, Int.MAX_VALUE)
        }
        for (t in 0..k) {
            var minCost = Int.MAX_VALUE
            run {
                var i = 0
                var j = 0
                while (i < points.size) {
                    minCost = min(
                        minCost,
                        costs[points[i][0]][points[i][1]]
                    )
                    if (i + 1 < points.size &&
                        grid[points[i][0]][points[i][1]] ==
                        grid[points[i + 1][0]][points[i + 1][1]]
                    ) {
                        i++
                        continue
                    }
                    for (r in j..i) {
                        costs[points[r][0]][points[r][1]] = minCost
                    }
                    j = i + 1
                    i++
                }
            }
            for (i in m - 1 downTo 0) {
                for (j in n - 1 downTo 0) {
                    if (i == m - 1 && j == n - 1) {
                        costs[i][j] = 0
                        continue
                    }
                    if (i != m - 1) {
                        costs[i][j] = min(
                            costs[i][j],
                            costs[i + 1][j] + grid[i + 1][j]
                        )
                    }
                    if (j != n - 1) {
                        costs[i][j] = min(
                            costs[i][j],
                            costs[i][j + 1] + grid[i][j + 1]
                        )
                    }
                }
            }
        }
        return costs[0][0]
    }
}
