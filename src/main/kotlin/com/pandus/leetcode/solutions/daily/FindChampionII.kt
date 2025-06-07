package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-champion-ii
class FindChampionII {
    fun findChampion(n: Int, edges: Array<IntArray>) =
        ((0..<n) - edges.map { it[1] }.toSet())
            .takeIf { it.size == 1 }?.first() ?: -1
}
