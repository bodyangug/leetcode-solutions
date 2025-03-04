package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three
class CheckIfNumberIsSumOfPowersOfThree {
    fun checkPowersOfThree(n: Int): Boolean {
        var num = n
        while (num > 0) {
            if (num % 3 == 2) return false
            num /= 3
        }
        return true
    }
}
