package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i
class NumberOfWaysToAssignEdgeWeightsI {
    fun assignEdgeWeights(edges: Array<IntArray>): Int {
        val mod = 1_000_000_007L
        val n = edges.size + 1
        val adj = Array(n + 1) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            adj[u].add(v)
            adj[v].add(u)
        }
        // BFS from node 1 to find max depth
        val depth = IntArray(n + 1) { -1 }
        depth[1] = 0
        val queue: ArrayDeque<Int> = ArrayDeque()
        queue.add(1)
        var maxDepth = 0
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (depth[node] > maxDepth) maxDepth = depth[node]
            for (next in adj[node]) {
                if (depth[next] == -1) {
                    depth[next] = depth[node] + 1
                    queue.add(next)
                }
            }
        }
        if (maxDepth == 0) return 0
        // Number of ways to make odd sum with k edges of weight 1 or 2 = 2^(k-1)
        var result = 1L
        var base = 2L
        var exp = (maxDepth - 1).toLong()
        while (exp > 0) {
            if (exp and 1L == 1L) result = result * base % mod
            base = base * base % mod
            exp = exp shr 1
        }
        return result.toInt()
    }
}
