package com.pandus.leetcode.solutions.daily

import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/xor-after-range-multiplication-queries-ii
class XORAfterRangeMultiplicationQueriesII {
    fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val mod = 1_000_000_007L
        val n = nums.size
        val b = sqrt(n.toDouble()).toInt() + 1

        val lazy = LongArray(n) { 1L }

        val smallQueries = Array(b + 1) { mutableListOf<IntArray>() }

        for (query in queries) {
            val k = query[2]
            if (k > b) {
                var idx = query[0]
                while (idx <= query[1]) {
                    lazy[idx] = lazy[idx] * query[3] % mod
                    idx += k
                }
            } else {
                smallQueries[k].add(query)
            }
        }

        for (k in 1..b) {
            if (smallQueries[k].isEmpty()) continue
            val diff = LongArray(n) { 1L }
            for (query in smallQueries[k]) {
                val l = query[0]
                val r = query[1]
                val v = query[3].toLong()
                diff[l] = diff[l] * v % mod
                val nextIdx = l + ((r - l) / k + 1) * k
                if (nextIdx < n) {
                    diff[nextIdx] = diff[nextIdx] * modPow(v, mod - 2, mod) % mod
                }
            }
            for (res in 0 until k) {
                var cumProd = 1L
                var i = res
                while (i < n) {
                    cumProd = cumProd * diff[i] % mod
                    lazy[i] = lazy[i] * cumProd % mod
                    i += k
                }
            }
        }

        var result = 0
        for (i in nums.indices) {
            result = result xor ((nums[i].toLong() * lazy[i] % mod).toInt())
        }
        return result
    }

    private fun modPow(base: Long, exp: Long, mod: Long): Long {
        var result = 1L
        var b = base % mod
        var e = exp
        while (e > 0) {
            if (e % 2 == 1L) result = result * b % mod
            b = b * b % mod
            e /= 2
        }
        return result
    }
}
