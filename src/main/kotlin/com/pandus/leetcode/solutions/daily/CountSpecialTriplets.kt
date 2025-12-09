package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-special-triplets
class CountSpecialTriplets {
    fun specialTriplets(nums: IntArray): Int {
        val MOD = 1000000007
        val numCnt: MutableMap<Int, Int> = HashMap()
        val numPartialCnt: MutableMap<Int, Int> = HashMap()

        for (v in nums) {
            numCnt[v] = numCnt.getOrDefault(v, 0) + 1
        }

        var ans: Long = 0
        for (v in nums) {
            val target = v * 2
            val lCnt: Int = numPartialCnt.getOrDefault(target, 0)
            numPartialCnt[v] = numPartialCnt.getOrDefault(v, 0) + 1
            val rCnt =
                numCnt.getOrDefault(target, 0) -
                        numPartialCnt.getOrDefault(target, 0)
            ans = (ans + lCnt.toLong() * rCnt) % MOD
        }
        return ans.toInt()
    }
}
