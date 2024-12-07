package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag
class MinimumLimitOfBallsInBag {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        var l = 1
        var h = nums.max()
        while (l <= h) {
            val m = (l + h) / 2
            val ops = nums.sumOf { (it - 1) / m }
            if (ops > maxOperations) l = m + 1 else h = m - 1
        }
        return l
    }
}
