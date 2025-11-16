package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-substrings-with-only-1s
class NumberOfSubstringsWithOnly1s {
    fun numSub(s: String): Int {
        val MODULO = 1_000_000_007L
        var total = 0L
        var consecutive = 0L

        s.forEach { c ->
            when (c) {
                '1' -> consecutive++
                else -> {
                    total = (total + consecutive * (consecutive + 1) / 2) % MODULO
                    consecutive = 0
                }
            }
        }

        total = (total + consecutive * (consecutive + 1) / 2) % MODULO
        return total.toInt()
    }
}
