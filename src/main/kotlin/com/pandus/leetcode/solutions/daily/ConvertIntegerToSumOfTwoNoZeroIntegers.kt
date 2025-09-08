package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers
class ConvertIntegerToSumOfTwoNoZeroIntegers {
    fun getNoZeroIntegers(n: Int): IntArray {
        fun isNoZero(x: Int) = !x.toString().contains('0')

        for (a in 1 until n) {
            val b = n - a
            if (isNoZero(a) && isNoZero(b)) {
                return intArrayOf(a, b)
            }
        }
        return intArrayOf() // guaranteed not to happen
    }
}
