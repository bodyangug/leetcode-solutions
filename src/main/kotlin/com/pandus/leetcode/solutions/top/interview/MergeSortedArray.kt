package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/merge-sorted-array/
class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        for ((secondPointer, pointer) in (m..<nums1.size).withIndex()) {
            nums1[pointer] = nums2[secondPointer]
        }
        nums1.sort()
    }
}
