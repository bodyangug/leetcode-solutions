package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-total-importance-of-roads
class MaximumTotalImportanceOfRoads {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val degree = LongArray(n)
        for (edge in roads) {
            degree[edge[0]]++
            degree[edge[1]]++
        }
        degree.sort()
        var value: Long = 1
        var totalImportance: Long = 0
        for (d in degree) {
            totalImportance += (value * d)
            value++
        }
        return totalImportance
    }
}