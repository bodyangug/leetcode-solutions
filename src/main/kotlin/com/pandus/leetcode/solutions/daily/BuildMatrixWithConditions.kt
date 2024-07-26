package com.pandus.leetcode.solutions.daily

import java.util.*


//Reference: https://leetcode.com/problems/build-a-matrix-with-conditions
class BuildMatrixWithConditions {
    fun buildMatrix(
        k: Int,
        rowConditions: Array<IntArray>,
        colConditions: Array<IntArray>
    ): Array<IntArray> {
        // Store the topologically sorted sequences.
        val orderRows = topoSort(rowConditions, k)
        val orderColumns = topoSort(colConditions, k)

        // If no topological sort exists, return empty array.
        if (orderRows.isEmpty() || orderColumns.isEmpty()) return Array(0) { IntArray(0) }

        val matrix = Array(k) { IntArray(k) }
        for (i in 0 until k) {
            for (j in 0 until k) {
                if (orderRows[i] == orderColumns[j]) {
                    matrix[i][j] = orderRows[i]
                }
            }
        }
        return matrix
    }

    private fun topoSort(edges: Array<IntArray>, n: Int): List<Int> {
        // Build adjacency list
        val adj: MutableList<MutableList<Int>> = ArrayList()
        for (i in 0..n) {
            adj.add(ArrayList())
        }
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
        }

        val order: MutableList<Int> = ArrayList()
        // 0: not visited, 1: visiting, 2: visited
        val visited = IntArray(n + 1)
        val hasCycle = booleanArrayOf(false)

        // Perform DFS for each node
        for (i in 1..n) {
            if (visited[i] == 0) {
                dfs(i, adj, visited, order, hasCycle)
                // Return empty if cycle detected
                if (hasCycle[0]) return ArrayList()
            }
        }

        // Reverse to get the correct order
        order.reverse()
        return order
    }

    private fun dfs(
        node: Int,
        adj: List<MutableList<Int>>,
        visited: IntArray,
        order: MutableList<Int>,
        hasCycle: BooleanArray
    ) {
        visited[node] = 1 // Mark node as visiting
        for (neighbor in adj[node]) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, adj, visited, order, hasCycle)
                // Early exit if a cycle is detected
                if (hasCycle[0]) return
            } else if (visited[neighbor] == 1) {
                // Cycle detected
                hasCycle[0] = true
                return
            }
        }
        // Mark node as visited
        visited[node] = 2
        // Add node to the order
        order.add(node)
    }
}