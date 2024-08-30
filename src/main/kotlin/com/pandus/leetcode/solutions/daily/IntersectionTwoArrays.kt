package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/intersection-of-two-arrays
class IntersectionTwoArrays {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1: MutableSet<Int> = HashSet()
        for (n in nums1) {
            set1.add(n)
        }
        val set2: MutableSet<Int> = HashSet()
        for (n in nums2) {
            set2.add(n)
        }
        set1.retainAll(set2)
        val output = IntArray(set1.size)
        var idx = 0
        for (s in set1) {
            output[idx++] = s
        }
        return output
    }
}
