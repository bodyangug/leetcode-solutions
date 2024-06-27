package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/find-center-of-star-graph
class FindCenterStarGraph {
    fun findCenter(edges: Array<IntArray>): Int {
        val degree: MutableMap<Int, Int> = HashMap()
        for (edge in edges) {
            degree[edge[0]] = degree.getOrDefault(edge[0], 0) + 1
            degree[edge[1]] = degree.getOrDefault(edge[1], 0) + 1
        }
        for (node in degree.keys) {
            if (degree[node] == edges.size) {
                return node
            }
        }
        return -1
    }
}