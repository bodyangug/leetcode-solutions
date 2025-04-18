package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-and-say
class CountAndSay {
    fun countAndSay(n: Int): String {
        if (n <= 0) return ""

        var current = "1"

        repeat(n - 1) {
            current = runLengthEncode(current)
        }
        return current
    }

    fun runLengthEncode(s: String): String {
        val sb = StringBuilder()
        var count = 1

        for (i in 1 until s.length) {
            if (s[i] == s[i - 1]) {
                count++
            } else {
                sb.append(count).append(s[i - 1])
                count = 1
            }
        }
        sb.append(count).append(s.last())
        return sb.toString()
    }
}
