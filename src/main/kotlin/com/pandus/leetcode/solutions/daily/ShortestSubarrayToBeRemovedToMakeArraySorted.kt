package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted
class ShortestSubarrayToBeRemovedToMakeArraySorted {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        var right = arr.size - 1
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--
        }
        if (right == 0) return 0

        var ans = right
        var left = 0
        while (left == 0 || (left < right && arr[left - 1] <= arr[left])) {
            while (right < arr.size && arr[left] > arr[right]) {
                right++
            }
            ans = minOf(ans, right - left - 1)
            left++
        }
        return ans
    }
}
