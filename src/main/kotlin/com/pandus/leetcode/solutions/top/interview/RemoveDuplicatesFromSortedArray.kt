package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/remove-duplicates-from-sorted-array
class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var s = 0
        for (i in nums.indices) {
            if (s == 0 || nums[i] != nums[s - 1]) {
                swap(nums, s, i)
                s++
            }
        }
        return s
    }

    private fun swap(nums: IntArray, idx1: Int, idx2: Int) {
        val temp = nums[idx1]
        nums[idx1] = nums[idx2]
        nums[idx2] = temp
    }
}
