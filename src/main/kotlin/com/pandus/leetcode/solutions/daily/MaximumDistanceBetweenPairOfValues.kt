package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-distance-between-a-pair-of-values
class MaximumDistanceBetweenPairOfValues {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        var ans = 0

        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] > nums2[j]) {
                i++
            } else {
                ans = maxOf(ans, j - i)
                j++
            }
        }

        return ans
    }
}
