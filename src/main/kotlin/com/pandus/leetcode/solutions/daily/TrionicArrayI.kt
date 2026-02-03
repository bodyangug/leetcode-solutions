package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/trionic-array-i
class TrionicArrayI {
    fun isTrionic(nums: IntArray): Boolean {
        val n = nums.size
        var i = 1
        while (i < n && nums[i - 1] < nums[i]) {
            i++
        }
        val p = i - 1
        while (i < n && nums[i - 1] > nums[i]) {
            i++
        }
        val q = i - 1
        while (i < n && nums[i - 1] < nums[i]) {
            i++
        }
        val flag = i - 1
        return (p != 0) && (q != p) && (flag == n - 1 && flag != q)
    }
}
