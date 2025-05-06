package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/build-array-from-permutation
class BuildArrayFromPermutation {
    fun buildArray(nums: IntArray): IntArray {
        val n = nums.size
        for (i in nums.indices) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n)
        }
        for (i in nums.indices) {
            nums[i] /= n
        }
        return nums
    }
}
