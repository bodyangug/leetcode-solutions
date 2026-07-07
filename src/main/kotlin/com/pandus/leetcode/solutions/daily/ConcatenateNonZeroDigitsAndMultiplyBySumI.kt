package com.pandus.leetcode.solutions.daily

// Reference: http://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i
class ConcatenateNonZeroDigitsAndMultiplyBySumI {
    fun sumAndMultiply(n: Int): Long {
        val nonZeroDigits = n.toString().filter { it != '0' }
        val x = if (nonZeroDigits.isEmpty()) 0 else nonZeroDigits.toLong()
        val sum = x.toString().map { it - '0' }.sum()
        return x * sum
    }
}
