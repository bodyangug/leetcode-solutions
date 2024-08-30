package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/set-mismatch
class SetMismatch {
    fun findErrorNums(nums: IntArray): IntArray {
        var duplicate = -1
        var missing = -1
        val count = IntArray(nums.size + 1)

        for (num in nums) {
            count[num]++
        }

        for (i in 1 until count.size) {
            when {
                count[i] == 0 -> missing = i
                count[i] > 1 -> duplicate = i
            }
        }
        return intArrayOf(duplicate, missing)
    }
}
