package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k
class PartitionArraySuchThatMaximumDifferenceIsK {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort() // idiomatic Kotlin sort
        var ans = 1
        var rec = nums[0]

        for (i in 1 until nums.size) {
            if (nums[i] - rec > k) {
                ans++
                rec = nums[i]
            }
        }
        return ans
    }
}
