package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i
class FindPowerOfKSizeSubarraysI {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        return IntArray(nums.size - k + 1) { start ->
            if ((start until start + k - 1).all { nums[it + 1] == nums[it] + 1 }) {
                nums[start + k - 1]
            } else {
                -1
            }
        }
    }
}
