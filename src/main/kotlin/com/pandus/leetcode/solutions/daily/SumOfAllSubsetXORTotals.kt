package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/sum-of-all-subset-xor-totals
class SumOfAllSubsetXORTotals {
    fun subsetXORSum(nums: IntArray): Int {
        return XORSum(nums, 0, 0)
    }

    private fun XORSum(nums: IntArray, index: Int, currentXOR: Int): Int {
        // Return currentXOR when all elements in nums are already considered
        if (index == nums.size) return currentXOR

        // Calculate sum of subset xor with current element
        val withElement = XORSum(nums, index + 1, currentXOR xor nums[index])

        // Calculate sum of subset xor without current element
        val withoutElement = XORSum(nums, index + 1, currentXOR)

        // Return sum of xor totals
        return withElement + withoutElement
    }
}