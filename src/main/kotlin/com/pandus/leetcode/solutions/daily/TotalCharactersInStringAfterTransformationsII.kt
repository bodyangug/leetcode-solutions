package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/total-characters-in-string-after-transformations-ii
class TotalCharactersInStringAfterTransformationsII {
    private val mod = 1_000_000_007L

    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        val mp = mutableMapOf<Int, MutableMap<Int, LongArray>>()

        // Base transformation: 1 step
        val baseMap = mutableMapOf<Int, LongArray>()
        for (i in 0 until 26) {
            val v = LongArray(26)
            for (j in 1..nums[i]) {
                v[(i + j) % 26]++
            }
            baseMap[i] = v
        }
        mp[1] = baseMap

        // Build all powers of transformations: 2, 4, 8, ..., up to t
        var m = 2
        while (m <= t) {
            val half = mp[m / 2]!!
            val currMap = mutableMapOf<Int, LongArray>()
            for (i in 0 until 26) {
                val v = LongArray(26)
                val pre = half[i]!!
                for (j in 0 until 26) {
                    val prex = half[j]!!
                    val mul = pre[j]
                    if (mul == 0L) continue
                    for (k in 0 until 26) {
                        v[k] = (v[k] + mul * prex[k] % mod) % mod
                    }
                }
                currMap[i] = v
            }
            mp[m] = currMap
            m *= 2
        }

        // Count of initial characters
        val c = LongArray(26)
        for (ch in s) {
            c[ch - 'a']++
        }

        // Apply transformation using binary decomposition of t
        var remaining = t
        var power = Integer.highestOneBit(t)
        while (remaining > 0) {
            if (remaining >= power) {
                val temp = LongArray(26)
                val transMap = mp[power]!!
                for (i in 0 until 26) {
                    val transform = transMap[i]!!
                    val count = c[i]
                    if (count == 0L) continue
                    for (j in 0 until 26) {
                        temp[j] = (temp[j] + count * transform[j] % mod) % mod
                    }
                }
                System.arraycopy(temp, 0, c, 0, 26)
                remaining -= power
            }
            power /= 2
        }

        return c.fold(0L) { acc, v -> (acc + v) % mod }.toInt()
    }
}
