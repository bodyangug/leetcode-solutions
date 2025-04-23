package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-largest-group
class CountLargestGroup {
    fun countLargestGroup(n: Int): Int {
        val groupCounts = IntArray(37)
        var maxCount = 0

        for (i in 1..n) {
            val sum = i.toString().sumOf { it - '0' }
            groupCounts[sum]++
            maxCount = maxOf(maxCount, groupCounts[sum])
        }
        return groupCounts.count { it == maxCount }
    }
}
