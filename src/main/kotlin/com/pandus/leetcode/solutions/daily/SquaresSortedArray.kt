package com.pandus.leetcode.solutions.daily

//reference: https://leetcode.com/problems/squares-of-a-sorted-array
class SquaresSortedArray {
    fun sortedSquares(nums: IntArray): IntArray {
        val N = nums.size
        val ans = IntArray(N)
        for (i in 0 until N) ans[i] = nums[i] * nums[i]
        ans.sort()
        return ans
    }
}