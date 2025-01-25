package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-eventual-safe-states
class FindEventualSafeStates {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val safe = HashMap<Int, Boolean>()
        fun dfs(i: Int, vis: HashSet<Int>): Boolean = safe.getOrPut(i) {
            vis.add(i) && graph[i].all { dfs(it, vis) }
        }
        return graph.indices.filter { dfs(it, HashSet()) }
    }
}
