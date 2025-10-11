package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-total-damage-with-spell-casting
class MaximumTotalDamageWithSpellCasting {
    fun maximumTotalDamage(power: IntArray): Long {
        // 1. Count the frequency of each power value
        val freq = mutableMapOf<Int, Int>()
        for (x in power) {
            freq[x] = freq.getOrDefault(x, 0) + 1
        }
        // 2. Sort unique power values in descending order
        val uniquePowers = freq.keys.sorted()
        val m = uniquePowers.size
        val gain = LongArray(m)
        for (i in 0 until m) {
            val v = uniquePowers[i]
            gain[i] = v.toLong() * freq[v]!!
        }

        val best = LongArray(m)
        // 3. Dynamic programming to find the maximum damage
        for (i in 0 until m) {
            val v = uniquePowers[i]
            val target = v - 3
            val j = lastIndexLeq(uniquePowers, target)
            val take = gain[i] + if (j >= 0) best[j] else 0L
            val skip = if (i > 0) best[i - 1] else 0L
            best[i] = maxOf(skip, take)
        }

        return best[m - 1]
    }

    private fun lastIndexLeq(a: List<Int>, x: Int): Int {
        var lo = 0
        var hi = a.size - 1
        var ans = -1
        while (lo <= hi) {
            val mid = (lo + hi) / 2
            if (a[mid] <= x) {
                ans = mid
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }
        return ans
    }
}
