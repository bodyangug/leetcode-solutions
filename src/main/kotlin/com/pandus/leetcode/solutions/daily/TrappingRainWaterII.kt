package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/trapping-rain-water-ii
class TrappingRainWaterII {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val m = heightMap.size - 1
        val n = heightMap[0].size - 1
        var res = 0
        val q = PriorityQueue<List<Int>>(compareBy { it[0] })
        for (y in 0..m) for (x in 0..n) if (min(x, y) < 1 || y == m || x == n)
            q += listOf(heightMap[y][x], y, x)
        while (q.size > 0) {
            val (min, y, x) = q.poll()
            heightMap[y][x] = -1
            for ((y1, x1) in listOf(y to x - 1, y - 1 to x, y to x + 1, y + 1 to x))
                if (y1 in 0..m && x1 in 0..n && heightMap[y1][x1] >= 0) {
                    q += listOf(max(min, heightMap[y1][x1]), y1, x1)
                    res += max(0, min - heightMap[y1][x1])
                    heightMap[y1][x1] = -1
                }
        }
        return res
    }
}
