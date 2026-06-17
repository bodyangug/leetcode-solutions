package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/process-string-with-special-operations-ii
class ProcessStringWithSpecialOperationsII {
    fun processStr(s: String, k: Long): Char {
        val cap = Long.MAX_VALUE / 2
        val lens = LongArray(s.length)
        var len = 0L
        for (i in s.indices) {
            len = when (val c = s[i]) {
                '*' -> if (len > 0) len - 1 else 0
                '#' -> if (len > cap) cap else len * 2
                '%' -> len
                else -> {
                    require(c in 'a'..'z')
                    if (len < cap) len + 1 else len
                }
            }
            lens[i] = len
        }
        if (k >= len) return '.'
        var idx = k
        for (i in s.indices.reversed()) {
            val prev = if (i == 0) 0L else lens[i - 1]
            when (val c = s[i]) {
                '*' -> {
                    /* idx < lens[i] <= prev, unchanged */
                }

                '#' -> if (idx >= prev) idx -= prev
                '%' -> idx = prev - 1 - idx
                else -> {
                    if (idx == lens[i] - 1) return c
                    // else idx < prev, unchanged
                }
            }
        }
        return '.'
    }
}
