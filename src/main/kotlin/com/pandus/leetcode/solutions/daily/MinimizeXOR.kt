package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimize-xor
class MinimizeXOR {
    fun minimizeXor(num1: Int, num2: Int): Int {
        var cnt = num2.countOneBits() - num1.countOneBits()
        var res = num1
        var b = 0
        while (cnt != 0) {
            while ((num1 and (1 shl b) > 0) == cnt > 0) b++
            res = res xor (1 shl b++)
            if (cnt > 0) cnt-- else cnt++
        }
        return res
    }
}
