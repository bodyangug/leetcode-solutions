package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-complete-components
class CountTheNumberOfCompleteComponents {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<Int>() }

        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        val visited = BooleanArray(n)
        var completeCount = 0

        fun dfs(node: Int, component: MutableList<Int>) {
            visited[node] = true
            component.add(node)
            for (neighbor in graph[node]) {
                if (!visited[neighbor]) {
                    dfs(neighbor, component)
                }
            }
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                val component = mutableListOf<Int>()
                dfs(i, component)

                val size = component.size
                var edgeCount = 0
                for (node in component) {
                    edgeCount += graph[node].size
                }

                if (edgeCount == size * (size - 1)) {
                    completeCount++
                }
            }
        }

        return completeCount
    }
}
