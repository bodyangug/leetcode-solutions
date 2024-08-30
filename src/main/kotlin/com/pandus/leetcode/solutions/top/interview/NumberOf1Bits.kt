package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/number-of-1-bits
class NumberOf1Bits {
    fun hammingWeight(n: Int): Int {
        return Integer.bitCount(n)
    }
}
