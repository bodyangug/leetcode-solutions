package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i
class FindXSumOfAllKLongSubarraysI {
    fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        val n = nums.size
        val ans = IntArray(n - k + 1)

        for (i in 0..n - k) {
            val cnt = mutableMapOf<Int, Int>()
            for (j in i until i + k) {
                cnt[nums[j]] = cnt.getOrDefault(nums[j], 0) + 1
            }

            val freq = cnt.map { (num, count) -> intArrayOf(count, num) }
                .sortedWith(compareByDescending<IntArray> { it[0] }.thenByDescending { it[1] })

            val xsum = freq.take(x).sumOf { it[0] * it[1] }
            ans[i] = xsum
        }
        return ans
    }
}
