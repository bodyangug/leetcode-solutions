package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays
class MakeTwoArraysEqualByReversingSubarrays {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        arr.sort()
        target.sort()
        for (i in arr.indices) {
            if (arr[i] != target[i]) return false
        }
        return true
    }
}