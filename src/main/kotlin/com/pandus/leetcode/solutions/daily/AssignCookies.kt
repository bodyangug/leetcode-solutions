package com.pandus.leetcode.solutions.daily

class AssignCookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var matches = 0
        for (j in s.indices) {
            if (matches < g.size && g[matches] <= s[j]) {
                matches++
            }
        }
        return matches
    }
}