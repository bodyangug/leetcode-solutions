package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/complement-of-base-10-integer
class ComplementOfBase10Integer {
    fun bitwiseComplement(n: Int): Int {
        if (n == 0) return 1
        var num = n
        var mask = 0
        while (num > 0) {
            mask = (mask shl 1) or 1
            num = num shr 1
        }
        return n.inv() and mask
    }
}
