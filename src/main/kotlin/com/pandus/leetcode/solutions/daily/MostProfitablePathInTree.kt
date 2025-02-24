package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/most-profitable-path-in-a-tree
class MostProfitablePathInTree {
    fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
        val n = amount.size
        val graph = Array(n) { mutableListOf<Int>() }
        val bobArrival = IntArray(n) { Int.MAX_VALUE }

        // Build the graph
        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        // Calculate Bob's arrival time for each node
        fun findBobTime(node: Int, parent: Int, time: Int): Boolean {
            if (node == 0) {
                bobArrival[node] = time
                return true
            }
            for (neighbor in graph[node]) {
                if (neighbor != parent && findBobTime(neighbor, node, time + 1)) {
                    bobArrival[node] = time
                    return true
                }
            }
            return false
        }
        findBobTime(bob, -1, 0)

        // DFS from root to find Alice's most profitable path
        fun dfs(node: Int, parent: Int, aliceTime: Int): Int {
            var maxProfit = Int.MIN_VALUE
            var isLeaf = true

            for (neighbor in graph[node]) {
                if (neighbor != parent) {
                    isLeaf = false
                    maxProfit = maxOf(maxProfit, dfs(neighbor, node, aliceTime + 1))
                }
            }

            val nodeProfit = when {
                aliceTime < bobArrival[node] -> amount[node]
                aliceTime == bobArrival[node] -> amount[node] / 2
                else -> 0
            }

            return nodeProfit + if (isLeaf) 0 else maxProfit
        }

        return dfs(0, -1, 0)
    }
}
