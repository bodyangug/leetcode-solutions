package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation
class MaximumBeautyOfArrayAfterApplyingOperation {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        val se = mutableListOf<Pair<Int, Int>>()
        for (n in nums) {
            se += (n + k) to 1
            se += (n - k) to -1
        }
        se.sortWith(compareBy({ it.first }, { it.second }))
        var cnt = 0
        return se.maxOf {
            cnt -= it.second
            cnt
        }
    }
}
