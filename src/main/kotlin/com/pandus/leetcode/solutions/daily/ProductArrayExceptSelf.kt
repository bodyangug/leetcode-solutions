package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/product-of-array-except-self
class ProductArrayExceptSelf {

    // O(n^2)
    fun productExceptSelf(nums: IntArray): IntArray {
        val ans = IntArray(nums.size) { 1 }
        for (indexToSkip in nums.indices) {
            for (idx in nums.indices) {
                if (indexToSkip == idx) continue
                ans[indexToSkip] *= nums[idx]
            }
        }
        return ans
    }

    // O(n)
    fun productExceptSelf2(nums: IntArray): IntArray {
        val length = nums.size
        val leftProduct = IntArray(length) { 1 }
        val rightProduct = IntArray(length) { 1 }
        val output = IntArray(length)

        for (i in 1 until length) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1]
        }

        for (i in length - 2 downTo 0) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1]
        }

        for (i in nums.indices) {
            output[i] = leftProduct[i] * rightProduct[i]
        }
        return output
    }
}
