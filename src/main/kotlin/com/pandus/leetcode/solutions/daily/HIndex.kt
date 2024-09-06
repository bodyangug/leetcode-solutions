package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/h-index
class HIndex {
    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()
        var h = 0
        for (i in citations.indices) {
            if (citations[i] >= i + 1) {
                h = i + 1
            } else {
                break
            }
        }
        return h
    }
}
