package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
class FindThePrefixCommonArrayOfTwoArrays {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray) =
        List(A.size) { A.slice(0..it).intersect(B.slice(0..it)).size }
}
