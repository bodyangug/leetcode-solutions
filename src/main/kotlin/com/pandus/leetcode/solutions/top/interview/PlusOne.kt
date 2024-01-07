package com.pandus.leetcode.solutions.top.interview

//Reference: https://leetcode.com/problems/plus-one
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val lastNum = digits.last()
        if (lastNum < 9) {
            digits[digits.size - 1] = lastNum + 1
            return digits
        }

        var inMind = 1
        for (index in digits.indices.reversed()) {
            if (digits[index] == 9) {
                digits[index] = 0
            } else {
                digits[index]++
                inMind = 0
                break
            }
        }

        if (inMind > 0) {
            return intArrayOf(1) + digits
        } else {
            return digits
        }
    }
}