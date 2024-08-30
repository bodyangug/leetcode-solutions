package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/reverse-bits
class ReverseBits {
    fun reverseBits(n: Int): Int {
        var ans = 0
        for (i in 0..31) {
            ans = ans.shl(1)
            ans = ans or (n.shr(i) and 1)
        }
        return ans
    }
}
