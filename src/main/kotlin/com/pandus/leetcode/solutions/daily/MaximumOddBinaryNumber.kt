package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-odd-binary-number
class MaximumOddBinaryNumber {
    fun maximumOddBinaryNumber(s: String): String {
        val arr = s.toCharArray().apply { this.sort() }
        val n = arr.size
        val secondLast = n - 2
        for (i in 0 until n / 2) {
            val temp = arr[i]
            arr[i] = arr[secondLast - i]
            arr[secondLast - i] = temp
        }
        return arr.concatToString()
    }
}
