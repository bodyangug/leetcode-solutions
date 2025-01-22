package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/map-of-highest-peak
class MapOfHighestPeak {
    fun highestPeak(isWater: Array<IntArray>) = isWater.apply {
        val q = ArrayDeque<Pair<Int, Int>>()
        val d = listOf(-1, 0, 1, 0, -1)
        for ((y, r) in withIndex()) for (x in r.indices)
            if (r[x] > 0) {
                r[x] = 0
                q += y to x
            } else r[x] = -1
        while (q.size > 0) {
            val (y, x) = q.removeFirst()
            for (i in 0..3) {
                val (y1, x1) = y + d[i] to x + d[i + 1]
                if ((getOrNull(y1)?.getOrNull(x1) ?: 0) < 0) {
                    this[y1][x1] = 1 + this[y][x]
                    q += y1 to x1
                }
            }
        }
    }
}
