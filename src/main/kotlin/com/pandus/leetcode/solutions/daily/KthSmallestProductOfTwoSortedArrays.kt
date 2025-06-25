package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays
class KthSmallestProductOfTwoSortedArrays {
    fun kthSmallestProduct(nums1: IntArray, nums2: IntArray, k: Long): Long {
        val n1 = nums1.size
        val n2 = nums2.size
        var pos1 = 0
        var pos2 = 0
        while (pos1 < n1 && nums1[pos1] < 0) {
            pos1++
        }
        while (pos2 < n2 && nums2[pos2] < 0) {
            pos2++
        }
        var left = (-1e10).toLong()
        var right = 1e10.toLong()
        while (left <= right) {
            val mid = (left + right) / 2
            var count: Long = 0
            var i1 = 0
            var i2 = pos2 - 1
            while (i1 < pos1 && i2 >= 0) {
                if (nums1[i1].toLong() * nums2[i2] > mid) {
                    i1++
                } else {
                    count += (pos1 - i1).toLong()
                    i2--
                }
            }
            i1 = pos1
            i2 = n2 - 1
            while (i1 < n1 && i2 >= pos2) {
                if (nums1[i1].toLong() * nums2[i2] > mid) {
                    i2--
                } else {
                    count += (i2 - pos2 + 1).toLong()
                    i1++
                }
            }
            i1 = 0
            i2 = pos2
            while (i1 < pos1 && i2 < n2) {
                if (nums1[i1].toLong() * nums2[i2] > mid) {
                    i2++
                } else {
                    count += (n2 - i2).toLong()
                    i1++
                }
            }
            i1 = pos1
            i2 = 0
            while (i1 < n1 && i2 < pos2) {
                if (nums1[i1].toLong() * nums2[i2] > mid) {
                    i1++
                } else {
                    count += (n1 - i1).toLong()
                    i2++
                }
            }
            if (count < k) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }
}
