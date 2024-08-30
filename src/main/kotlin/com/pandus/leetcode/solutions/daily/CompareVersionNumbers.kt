package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/compare-version-numbers
class CompareVersionNumbers {
    fun compareVersion(version1: String, version2: String): Int {
        val nums1 = version1.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val nums2 = version2.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val n1 = nums1.size
        val n2 = nums2.size

        // compare versions
        var i1: Int
        var i2: Int
        for (i in 0 until max(n1, n2)) {
            i1 = if (i < n1) nums1[i].toInt() else 0
            i2 = if (i < n2) nums2[i].toInt() else 0
            if (i1 != i2) {
                return if (i1 > i2) 1 else -1
            }
        }
        return 0
    }
}
