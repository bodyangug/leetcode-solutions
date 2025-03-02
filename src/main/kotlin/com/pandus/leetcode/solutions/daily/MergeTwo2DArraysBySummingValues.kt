package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values
class MergeTwo2DArraysBySummingValues {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        val keyToSum = TreeMap<Int, Int>()

        // Merge both arrays in one loop
        for (nums in nums1 + nums2) {
            keyToSum.merge(nums[0], nums[1], Int::plus)
        }

        // Construct the result array directly
        return keyToSum.map { (key, value) -> intArrayOf(key, value) }.toTypedArray()
    }
}
