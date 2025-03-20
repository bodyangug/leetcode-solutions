package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph
class MinimumCostWalkInWeightedGraph {
    // Use a data class for readability
    data class Edge(val to: Int, val weight: Int)

    fun minimumCost(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        // Initialize adjacency list
        val adjList = List(n) { mutableListOf<Edge>() }
        for ((u, v, w) in edges) {
            adjList[u].add(Edge(v, w))
            adjList[v].add(Edge(u, w))
        }

        val visited = BooleanArray(n)
        val components = IntArray(n) { -1 }
        val componentCost = mutableListOf<Int>()

        var componentId = 0
        for (node in 0 until n) {
            if (!visited[node]) {
                // Calculate cost and assign component ID
                val cost = bfsComponentCost(node, adjList, visited, components, componentId)
                componentCost.add(cost)
                componentId++
            }
        }

        // Answer queries
        return queries.map { (start, end) ->
            if (components[start] == components[end]) componentCost[components[start]] else -1
        }.toIntArray()
    }

    // Optimized BFS function with ArrayDeque
    private fun bfsComponentCost(
        source: Int,
        adjList: List<List<Edge>>,
        visited: BooleanArray,
        components: IntArray,
        componentId: Int
    ): Int {
        val queue = ArrayDeque<Int>()
        queue.add(source)
        visited[source] = true
        var cost = Int.MAX_VALUE

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            components[node] = componentId

            for (edge in adjList[node]) {
                cost = cost and edge.weight
                if (!visited[edge.to]) {
                    visited[edge.to] = true
                    queue.add(edge.to)
                }
            }
        }
        return cost
    }
}
