package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/minimum-cost-path-with-edge-reversals
class MinimumCostPathWithEdgeReversals {
    fun minCost(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]
            graph[u].add(Pair(v, w))
            graph[v].add(Pair(u, 2 * w))
        }

        val dist = IntArray(n) { Int.MAX_VALUE }
        dist[0] = 0
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(Pair(0, 0)) // (node, cost)

        while (pq.isNotEmpty()) {
            val (node, cost) = pq.poll()
            if (cost > dist[node]) continue
            for ((neighbor, weight) in graph[node]) {
                val newCost = cost + weight
                if (newCost < dist[neighbor]) {
                    dist[neighbor] = newCost
                    pq.add(Pair(neighbor, newCost))
                }
            }
        }
        return if (dist[n - 1] == Int.MAX_VALUE) -1 else dist[n - 1]
    }
}
