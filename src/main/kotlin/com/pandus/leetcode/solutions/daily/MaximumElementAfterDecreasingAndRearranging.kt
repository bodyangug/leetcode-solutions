package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging
class MaximumElementAfterDecreasingAndRearranging {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()
        arr[0] = 1
        for (i in 1 until arr.size) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1
            }
        }
        return arr[arr.size - 1]
    }
}
