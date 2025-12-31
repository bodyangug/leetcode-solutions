package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/apple-redistribution-into-boxes
class AppleRedistributionIntoBoxes {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        val totalApples = apple.sum()
        val sortedCapacity = capacity.sortedDescending()
        var boxesUsed = 0
        var applesRemaining = totalApples
        for (cap in sortedCapacity) {
            if (applesRemaining <= 0) break
            applesRemaining -= cap
            boxesUsed++
        }
        return boxesUsed
    }
}
