package com.pandus.leetcode.solutions.daily

import kotlin.math.ln

// Reference: https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k
class LongestBinarySubsequenceLessThanOrEqualToK {
    fun longestSubsequence(s: String, k: Int): Int {
        var sm = 0
        var cnt = 0
        val bits = (ln(k.toDouble()) / ln(2.0)).toInt() + 1
        val n = s.length
        for (i in 0 until n) {
            val idx = n - 1 - i
            val ch = s[idx]
            if (ch == '1') {
                if (i < bits) {
                    val power = 1 shl i
                    if (sm + power <= k) {
                        sm += power
                        cnt++
                    }
                }
            } else {
                cnt++
            }
        }
        return cnt
    }
}
