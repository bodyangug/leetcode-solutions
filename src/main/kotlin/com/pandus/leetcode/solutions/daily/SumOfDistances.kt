package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sum-of-distances
class SumOfDistances {
    fun distance(nums: IntArray): LongArray {
        val n = nums.size
        val groups: MutableMap<Int, MutableList<Int>> = HashMap()
        for (i in 0..<n) {
            groups.computeIfAbsent(nums[i]) { _: Int -> ArrayList() }.add(i)
        }
        val res = LongArray(n)
        for (group in groups.values) {
            var total: Long = 0
            for (idx in group) {
                total += idx.toLong()
            }
            var prefixTotal: Long = 0
            val sz = group.size
            for (i in 0..<sz) {
                val idx: Int = group[i]
                res[idx] = total - prefixTotal * 2 + idx.toLong() * (2 * i - sz)
                prefixTotal += idx.toLong()
            }
        }
        return res
    }
}
