package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/find-if-path-exists-in-graph
class FindIfPathExistsInGraph {
    fun validPath(
        n: Int,
        edges: Array<IntArray>,
        source: Int,
        destination: Int
    ): Boolean {
        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        edges.forEach {
            val a = it[0]
            val b = it[1]
            graph.computeIfAbsent(a) { ArrayList() }.add(b)
            graph.computeIfAbsent(b) { ArrayList() }.add(a)
        }
        return dfs(graph, BooleanArray(n), source, destination)
    }

    private fun dfs(
        graph: Map<Int, List<Int>>,
        seen: BooleanArray,
        currNode: Int,
        destination: Int
    ): Boolean {
        if (currNode == destination) {
            return true
        }
        if (!seen[currNode]) {
            seen[currNode] = true
            for (nextNode in graph[currNode]!!) {
                if (dfs(graph, seen, nextNode, destination)) {
                    return true
                }
            }
        }
        return false
    }
}
