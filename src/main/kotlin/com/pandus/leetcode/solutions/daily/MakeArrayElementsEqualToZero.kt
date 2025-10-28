package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/make-array-elements-equal-to-zero
class MakeArrayElementsEqualToZero {
    fun countValidSelections(nums: IntArray): Int {
        var count = 0
        var nonZeros = 0
        val n = nums.size
        for (x in nums) if (x > 0) nonZeros++
        for (i in 0..<n) {
            if (nums[i] == 0) {
                if (isValid(nums, nonZeros, i, -1)) count++
                if (isValid(nums, nonZeros, i, 1)) count++
            }
        }
        return count
    }

    private fun isValid(
        nums: IntArray,
        nonZeros: Int,
        start: Int,
        direction: Int
    ): Boolean {
        var nonZeros = nonZeros
        var direction = direction
        val n = nums.size
        var curr = start
        val temp = nums.clone()
        while (nonZeros > 0 && curr >= 0 && curr < n) {
            if (temp[curr] > 0) {
                temp[curr]--
                direction *= -1
                if (temp[curr] == 0) nonZeros--
            }
            curr += direction
        }
        return nonZeros == 0
    }
}
