package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/largest-color-value-in-a-directed-graph
class LargestColorValueInDirectedGraph {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val n = colors.length
        val graph = Array(n) { mutableListOf<Int>() }
        val inDegree = IntArray(n)

        // Build graph and in-degrees
        for ((u, v) in edges) {
            graph[u].add(v)
            inDegree[v]++
        }

        val dp = Array(n) { IntArray(26) } // dp[node][color] = count
        val queue: ArrayDeque<Int> = ArrayDeque()

        // Initialize queue with nodes having in-degree 0
        for (i in 0 until n) {
            if (inDegree[i] == 0) queue.add(i)
            dp[i][colors[i] - 'a'] = 1
        }

        var visited = 0
        var result = 0

        while (queue.isNotEmpty()) {
            val u = queue.removeFirst()
            visited++
            for (v in graph[u]) {
                for (c in 0 until 26) {
                    val add = if (colors[v] - 'a' == c) 1 else 0
                    dp[v][c] = maxOf(dp[v][c], dp[u][c] + add)
                }
                inDegree[v]--
                if (inDegree[v] == 0) queue.add(v)
            }
            result = maxOf(result, dp[u].maxOrNull() ?: 0)
        }

        return if (visited != n) -1 else result
    }
}
