package com.pandus.leetcode.solutions.daily

import java.util.*


//Reference: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
class FindCityWithSmallestNumberOfNeighborsAtThresholdDistance {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val adjacencyList = Array(n) { mutableListOf<IntArray>() }
        val shortestPathMatrix = Array(n) { IntArray(n) { Int.MAX_VALUE } }

        for (i in 0 until n) {
            shortestPathMatrix[i][i] = 0 // Distance to itself is zero
        }

        for (edge in edges) {
            val start = edge[0]
            val end = edge[1]
            val weight = edge[2]
            adjacencyList[start].add(intArrayOf(end, weight))
            adjacencyList[end].add(intArrayOf(start, weight)) // For undirected graph
        }

        for (i in 0 until n) {
            dijkstra(n, adjacencyList, shortestPathMatrix[i], i)
        }

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold)
    }

    // Dijkstra's algorithm to find shortest paths from a source city
    private fun dijkstra(
        n: Int,
        adjacencyList: Array<MutableList<IntArray>>,
        shortestPathDistances: IntArray,
        source: Int
    ) {
        // Priority queue to process nodes with the smallest distance first
        val priorityQueue = PriorityQueue(compareBy<IntArray> { it[1] })
        priorityQueue.add(intArrayOf(source, 0))
        Arrays.fill(shortestPathDistances, Int.MAX_VALUE) // Set all distances to infinity
        shortestPathDistances[source] = 0 // Distance to source itself is zero

        // Process nodes in priority order
        while (priorityQueue.isNotEmpty()) {
            val current = priorityQueue.poll()
            val currentCity = current[0]
            val currentDistance = current[1]
            if (currentDistance > shortestPathDistances[currentCity]) {
                continue
            }

            // Update distances to neighboring cities
            for (neighbor in adjacencyList[currentCity]) {
                val neighborCity = neighbor[0]
                val edgeWeight = neighbor[1]
                if (shortestPathDistances[neighborCity] > currentDistance + edgeWeight) {
                    shortestPathDistances[neighborCity] = currentDistance + edgeWeight
                    priorityQueue.add(intArrayOf(neighborCity, shortestPathDistances[neighborCity]))
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    private fun getCityWithFewestReachable(n: Int, shortestPathMatrix: Array<IntArray>, distanceThreshold: Int): Int {
        var cityWithFewestReachable = -1
        var fewestReachableCount = n

        // Count number of cities reachable within the distance threshold for each city
        for (i in 0 until n) {
            var reachableCount = 0
            for (j in 0 until n) {
                if (i == j) continue // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount
                cityWithFewestReachable = i
            }
        }
        return cityWithFewestReachable
    }

}