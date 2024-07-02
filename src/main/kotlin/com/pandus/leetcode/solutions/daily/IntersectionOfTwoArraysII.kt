package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/intersection-of-two-arrays-ii
class IntersectionOfTwoArraysII {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val listNum1 = nums1.toMutableList()
        val listNum2 = nums2.toMutableList()

        val result: MutableList<Int> = ArrayList()
        for (integer in listNum1) {
            if (listNum2.contains(integer)) {
                listNum2.remove(integer)
                result.add(integer)
            }
        }
        return result.stream().mapToInt { obj: Int -> obj }.toArray()
    }
}