package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/max-chunks-to-make-sorted
class MaxChunksToMakeSorted {
    fun maxChunksToSorted(arr: IntArray): Int {
        var chunkCount = 0
        var max = Integer.MIN_VALUE
        for (i in arr.indices) {
            max = maxOf(max, arr[i])
            if (max == i) {
                chunkCount++
                max = Integer.MIN_VALUE
            }
        }
        return chunkCount
    }
}
