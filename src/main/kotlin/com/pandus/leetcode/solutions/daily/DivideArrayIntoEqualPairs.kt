package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/divide-array-into-equal-pairs
class DivideArrayIntoEqualPairs {
    fun divideArray(nums: IntArray): Boolean {
        // Sort array to group equal elements together
        nums.sort()
        // Check consecutive pairs in sorted array
        var pos = 0
        while (pos < nums.size) {
            if (nums[pos] != nums[pos + 1]) {
                return false
            }
            pos += 2
        }
        return true
    }
}
