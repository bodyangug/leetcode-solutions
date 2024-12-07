package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i
class MaximumNumberOfIntegersToChooseFromRangeI {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val bannedSet = Array<Boolean>(10005) { false }
        for (v in banned) {
            bannedSet[v] = true
        }
        var count = 0
        var sum = 0
        for (i in 1..n) {
            if (sum + i <= maxSum && !bannedSet[i]) {
                count++
                sum += i
            }
        }
        return count
    }
}
