package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-array-end
class MinimumArrayEnd {
    fun minEnd(n: Int, x: Int): Long {
        var toAdd = (n - 1).toLong()
        var mask = 1L
        var current = x.toLong()
        while (toAdd != 0L) {
            while (current and mask != 0L) {
                mask = mask shl 1
            }
            if (toAdd and 1L == 1L) {
                current = current or mask
            }
            toAdd = toAdd shr 1
            mask = mask shl 1
        }
        return current
    }
}
