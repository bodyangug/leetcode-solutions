package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/grid-game
class GridGame {
    fun gridGame(grid: Array<IntArray>): Long {
        var a = grid[0].sumOf { it.toLong() }
        var b = 0L
        return grid[0].zip(
            grid[1]
        )
            .minOf { (u, v) ->
                a -= u
                max(a, b).also { b += v }
            }
    }
}
