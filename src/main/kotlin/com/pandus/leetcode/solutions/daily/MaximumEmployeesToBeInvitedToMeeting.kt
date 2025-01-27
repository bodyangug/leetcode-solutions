package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting
class MaximumEmployeesToBeInvitedToMeeting {
    fun maximumInvitations(fav: IntArray): Int {
        val g = Array(fav.size) { ArrayList<Int>() }
        for (i in fav.indices) if (fav[fav[i]] != i) g[fav[i]] += i
        fun dfs(i: Int): Int = 1 + (g[i].maxOfOrNull { dfs(it) } ?: 0)
        val vis = IntArray(fav.size)
        return max(
            fav.indices.sumOf { if (fav[fav[it]] == it) dfs(it) else 0 },
            fav.indices.maxOf { i ->
                var cycle = 0
                var j = i
                var k = i
                while (vis[j] < 1) {
                    cycle++
                    vis[j]++
                    j = fav[j]
                }
                while (j != k) {
                    cycle--
                    k = fav[k]
                }
                cycle
            }
        )
    }
}
