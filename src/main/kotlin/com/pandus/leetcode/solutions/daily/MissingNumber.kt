package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/missing-number
class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        nums.sort()
        var mustBe = 0
        var ans = -1

        for (index in nums.indices) {
            if (nums[index] != mustBe) {
                ans = mustBe
                break
            }
            mustBe++
        }

        if (ans == -1) {
            return nums.size
        }
        return ans
    }
}

fun main() {
    MissingNumber().missingNumber(intArrayOf(0, 1))
}