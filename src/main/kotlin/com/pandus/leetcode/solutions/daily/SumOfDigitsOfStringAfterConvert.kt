package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sum-of-digits-of-string-after-convert
class SumOfDigitsOfStringAfterConvert {
    fun getLucky(s: String, k: Int): Int {
        var digits = s.map { (it - 'a' + 1) }.joinToString("")
        repeat(k) {
            digits = digits.sumOf { it.digitToInt() }.toString()
        }
        return digits.toInt()
    }
}
