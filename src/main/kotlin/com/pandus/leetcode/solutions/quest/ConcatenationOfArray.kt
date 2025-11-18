package com.pandus.leetcode.solutions.quest

// Reference: https://leetcode.com/problems/concatenation-of-array
class ConcatenationOfArray {
    fun getConcatenation(nums: IntArray): IntArray {
        val ans = IntArray(nums.size * 2)
        for (i in nums.indices) {
            ans[i] = nums[i]
            ans[i + nums.size] = nums[i]
        }
        return ans
    }
}
