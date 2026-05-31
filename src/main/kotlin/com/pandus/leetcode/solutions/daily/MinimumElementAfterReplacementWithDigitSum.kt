package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum
class MinimumElementAfterReplacementWithDigitSum {
    fun minElement(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        for (num in nums) {
            var sum = 0
            var n = num
            while (n > 0) {
                sum += n % 10
                n /= 10
            }
            if (sum < min) min = sum
        }
        return min
    }
}
