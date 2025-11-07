package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximize-the-minimum-powered-city
class MaximizeTheMinimumPoweredCity {
    fun maxPower(stations: IntArray, r: Int, k: Int): Long {
        val n = stations.size
        val cnt = LongArray(n + 1)

        for (i in 0..<n) {
            val left = (i - r).coerceAtLeast(0)
            val right = (i + r + 1).coerceAtMost(n)
            cnt[left] += stations[i].toLong()
            cnt[right] -= stations[i].toLong()
        }

        var lo = stations.minOrNull()?.toLong() ?: 0L
        var hi = stations.sumOf { it.toLong() } + k
        var res = 0L

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (check(cnt, mid, r, k)) {
                res = mid
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }
        return res
    }

    private fun check(cnt: LongArray, targetValue: Long, r: Int, k: Int): Boolean {
        val n = cnt.size - 1
        val diff = cnt.copyOf()
        var sum = 0L
        var remaining = k.toLong()

        for (i in 0..<n) {
            sum += diff[i]
            if (sum < targetValue) {
                val add = targetValue - sum
                if (remaining < add) {
                    return false
                }
                remaining -= add
                val end = (i + 2 * r + 1).coerceAtMost(n)
                diff[end] -= add
                sum += add
            }
        }
        return true
    }
}
