package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/process-string-with-special-operations-i
class ProcessStringWithSpecialOperationsI {
    fun processStr(s: String): String {
        val result = StringBuilder()
        for (c in s) {
            when (c) {
                '*' -> if (result.isNotEmpty()) result.deleteCharAt(result.length - 1)
                '#' -> result.append(result.toString())
                '%' -> result.reverse()
                else -> result.append(c)
            }
        }
        return result.toString()
    }
}
