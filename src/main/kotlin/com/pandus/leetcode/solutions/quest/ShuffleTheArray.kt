package com.pandus.leetcode.solutions.quest

// Reference: https://leetcode.com/problems/shuffle-the-array
class ShuffleTheArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val ans = IntArray(nums.size)
        for (i in 0 until n) {
            ans[2 * i] = nums[i]
            ans[2 * i + 1] = nums[i + n]
        }
        return ans
    }
}
