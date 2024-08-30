package com.pandus.leetcode.solutions.daily

class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) return ""

        val dictT = t.groupingBy { it }.eachCount()

        val required = dictT.size

        var left = 0
        var right = 0

        var formed = 0

        val windowCounts = mutableMapOf<Char, Int>()

        val ans = intArrayOf(-1, 0, 0)

        while (right < s.length) {
            val char = s[right]
            windowCounts[char] = windowCounts.getOrDefault(char, 0) + 1

            dictT[char]?.let { if (windowCounts[char] == it) formed++ }

            while (left <= right && formed == required) {
                val c = s[left]
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1
                    ans[1] = left
                    ans[2] = right
                }
                windowCounts[c] = windowCounts[c]!! - 1
                dictT[c]?.let { if (windowCounts[c]!! < it) formed-- }

                left++
            }
            right++
        }
        return if (ans[0] == -1) "" else s.substring(ans[1], ans[2] + 1)
    }
}
