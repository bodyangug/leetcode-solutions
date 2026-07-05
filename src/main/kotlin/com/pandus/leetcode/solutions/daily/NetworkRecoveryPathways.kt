package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

// Reference: https://leetcode.com/problems/network-recovery-pathways
class NetworkRecoveryPathways {
    fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
        val n = online.size
        val graph = Array(n) { mutableListOf<IntArray>() }
        for (e in edges) graph[e[0]].add(intArrayOf(e[1], e[2]))

        // Minimum total cost from 0 to n-1 using only edges with cost >= minEdge,
        // traversing only online intermediate nodes. Returns Long.MAX_VALUE if no
        // such path with total cost <= k exists.
        fun minTotalCost(minEdge: Int): Long {
            val dist = LongArray(n) { Long.MAX_VALUE }
            dist[0] = 0L
            val pq = PriorityQueue<LongArray>(compareBy { it[0] })
            pq.add(longArrayOf(0L, 0L))
            while (pq.isNotEmpty()) {
                val top = pq.poll()
                val d = top[0]
                val u = top[1].toInt()
                if (d > dist[u]) continue
                if (u == n - 1) return d
                for (edge in graph[u]) {
                    val v = edge[0]
                    val c = edge[1]
                    if (c < minEdge) continue
                    if (v != n - 1 && !online[v]) continue
                    val nd = d + c
                    if (nd <= k && nd < dist[v]) {
                        dist[v] = nd
                        pq.add(longArrayOf(nd, v.toLong()))
                    }
                }
            }
            return Long.MAX_VALUE
        }

        if (minTotalCost(0) == Long.MAX_VALUE) return -1

        val costs = edges.map { it[2] }.toSortedSet().toIntArray()
        var lo = 0
        var hi = costs.size - 1
        var ans = 0
        while (lo <= hi) {
            val mid = (lo + hi) ushr 1
            if (minTotalCost(costs[mid]) != Long.MAX_VALUE) {
                ans = costs[mid]
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }
        return ans
    }
}
