package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/count-number-of-trapezoids-ii
class CountNumberOfTrapezoidsII {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val n = points.size
        val inf = 1e9 + 7
        val slopeToIntercept: MutableMap<Double, MutableList<Double>> = hashMapOf()
        val midToSlope: MutableMap<Int, MutableList<Double>> = hashMapOf()
        var ans = 0

        for (i in 0..<n) {
            val x1 = points[i][0]
            val y1 = points[i][1]
            for (j in i + 1..<n) {
                val x2 = points[j][0]
                val y2 = points[j][1]
                val dx = x1 - x2
                val dy = y1 - y2
                var k: Double
                var b: Double

                if (x2 == x1) {
                    k = inf
                    b = x1.toDouble()
                } else {
                    k = (1.0 * (y2 - y1)) / (x2 - x1)
                    b = (1.0 * (y1 * dx - x1 * dy)) / dx
                }
                if (k == -0.0) {
                    k = 0.0
                }
                if (b == -0.0) {
                    b = 0.0
                }
                val mid = (x1 + x2) * 10000 + (y1 + y2)
                slopeToIntercept
                    .computeIfAbsent(k) { key: Double -> ArrayList<Double>() }
                    .add(b)
                midToSlope
                    .computeIfAbsent(mid) { key: Int -> ArrayList<Double>() }
                    .add(k)
            }
        }

        for (sti in slopeToIntercept.values) {
            if (sti.size == 1) {
                continue
            }
            val cnt: MutableMap<Double, Int> = TreeMap()
            for (b in sti) {
                cnt[b] = cnt.getOrDefault(b, 0) + 1
            }
            var sum = 0
            for (count in cnt.values) {
                ans += sum * count
                sum += count
            }
        }

        for (mts in midToSlope.values) {
            if (mts.size == 1) {
                continue
            }
            val cnt: MutableMap<Double, Int> = TreeMap()
            for (k in mts) {
                cnt[k] = cnt.getOrDefault(k, 0) + 1
            }
            var sum = 0
            for (count in cnt.values) {
                ans -= sum * count
                sum += count
            }
        }
        return ans
    }
}
