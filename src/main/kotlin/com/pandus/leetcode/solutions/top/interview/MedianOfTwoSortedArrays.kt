package com.pandus.leetcode.solutions.top.interview

import java.util.stream.Collectors

// Reference: https://leetcode.com/problems/median-of-two-sorted-arrays
class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val general: MutableList<Int> = ArrayList(nums1.size + nums2.size)
        val nums1List: MutableList<Int> = ArrayList()
        for (i in nums1) {
            nums1List.add(i)
        }
        val nums2List: MutableList<Int> = ArrayList()
        for (i in nums2) {
            nums2List.add(i)
        }
        general.addAll(nums1List)
        general.addAll(nums2List)
        val collect = general.stream().sorted().collect(Collectors.toList())
        val size = collect.size
        val median: Double = if (size % 2 == 0) {
            val firstPosition = size / 2
            val secondPosition = size / 2 - 1
            val first = collect[firstPosition]
            val second = collect[secondPosition]
            (first + second) / 2.0
        } else {
            val middle = size / 2
            collect[middle].toDouble()
        }
        return median
    }
}
