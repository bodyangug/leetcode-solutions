package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/squares-of-a-sorted-array
class SquaresSortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n)
        for (i in 0 until n) ans[i] = nums[i] * nums[i]
        ans.sort()
        return ans
    }
}
