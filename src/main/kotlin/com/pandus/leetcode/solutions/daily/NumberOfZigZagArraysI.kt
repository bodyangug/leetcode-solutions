package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-zigzag-arrays-i
class NumberOfZigZagArraysI {
    fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val mod = 1_000_000_007L
        val k = r - l + 1
        if (n == 1) return k % mod.toInt()

        // up[v] = number of zigzag sequences of current length ending at value v with last step up (prev < v)
        // down[v] = same but last step down (prev > v)
        // Values indexed 0..k-1.
        var up = LongArray(k) { 1L }
        var down = LongArray(k) { 1L }

        for (i in 2..n) {
            val newUp = LongArray(k)
            val newDown = LongArray(k)
            // prefix sum of down for "u < v"
            var pref = 0L
            for (v in 0 until k) {
                newUp[v] = pref
                pref = (pref + down[v]) % mod
            }
            // suffix sum of up for "u > v"
            var suf = 0L
            for (v in k - 1 downTo 0) {
                newDown[v] = suf
                suf = (suf + up[v]) % mod
            }
            up = newUp
            down = newDown
        }

        var ans = 0L
        for (v in 0 until k) {
            ans = (ans + up[v] + down[v]) % mod
        }
        return ans.toInt()
    }
}
