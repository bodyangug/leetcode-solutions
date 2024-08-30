package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-common-value
class MinimumCommonValue {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        val set1: MutableSet<Int> = HashSet()

        for (num in nums1) {
            set1.add(num)
        }
        for (num in nums2) {
            if (set1.contains(num)) {
                return num
            }
        }
        return -1
    }
}
