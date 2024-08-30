package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/modify-graph-edge-weights
class ModifyGraphEdgeWeights {
    private val inf: Int = 2e9.toInt()

    fun modifiedGraphEdges(
        n: Int,
        edges: Array<IntArray>,
        source: Int,
        destination: Int,
        target: Int
    ): Array<IntArray> {
        val currentShortestDistance = runDijkstra(edges, n, source, destination)

        // If the current shortest distance is less than the target, return an empty result
        if (currentShortestDistance < target) return Array(0) { IntArray(0) }

        var matchesTarget = (currentShortestDistance == target.toLong())

        // Step 2: Iterate through each edge to adjust its weight if necessary
        for (edge in edges) {
            // Skip edges that already have a positive weight
            if (edge[2] > 0) continue

            // Set edge weight to a large value if current distance matches target, else set to 1
            edge[2] = if (matchesTarget) inf else 1

            // Step 3: If current shortest distance does not match target
            if (!matchesTarget) {
                // Compute the new shortest distance with the updated edge weight
                val newDistance = runDijkstra(edges, n, source, destination)
                // If the new distance is within the target range, update edge weight to match target
                if (newDistance <= target) {
                    matchesTarget = true
                    edge[2] += (target - newDistance).toInt()
                }
            }
        }
        // Return modified edges if the target distance is achieved, otherwise return an empty result
        return if (matchesTarget) edges else Array(0) { IntArray(0) }
    }

    private fun runDijkstra(edges: Array<IntArray>, n: Int, source: Int, destination: Int): Long {
        // Step 1: Initialize adjacency matrix and distance arrays
        val adjMatrix = Array(n) { LongArray(n) { inf.toLong() } }
        val minDistance = LongArray(n) { inf.toLong() }
        val visited = BooleanArray(n)

        // Set the distance to the source node as 0
        minDistance[source] = 0
        // Step 2: Fill the adjacency matrix with edge weights
        for (edge in edges) {
            if (edge[2] != -1) {
                adjMatrix[edge[0]][edge[1]] = edge[2].toLong()
                adjMatrix[edge[1]][edge[0]] = edge[2].toLong()
            }
        }

        // Step 3: Perform Dijkstra's algorithm
        for (i in 0 until n) {
            var nearestUnvisitedNode = -1
            for (j in 0 until n) {
                if (!visited[j] && (nearestUnvisitedNode == -1 || minDistance[j] < minDistance[nearestUnvisitedNode])) {
                    nearestUnvisitedNode = j
                }
            }
            // Mark the nearest node as visited
            visited[nearestUnvisitedNode] = true

            // Update the minimum distance for each adjacent node
            for (v in 0 until n) {
                minDistance[v] =
                    min(minDistance[v], (minDistance[nearestUnvisitedNode] + adjMatrix[nearestUnvisitedNode][v]))
            }
        }
        return minDistance[destination]
    }
}
