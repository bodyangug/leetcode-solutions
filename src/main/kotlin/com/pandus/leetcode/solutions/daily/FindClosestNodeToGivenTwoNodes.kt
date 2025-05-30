package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/find-closest-node-to-given-two-nodes
class FindClosestNodeToGivenTwoNodes {
    private fun bfs(startNode: Int, edges: IntArray, dist: IntArray) {
        val n = edges.size
        val q: Queue<Int> = LinkedList()
        val visited = BooleanArray(n)

        q.offer(startNode)
        dist[startNode] = 0

        while (q.isNotEmpty()) {
            val node = q.poll()

            if (visited[node]) continue
            visited[node] = true

            val neighbor = edges[node]
            if (neighbor != -1 && !visited[neighbor]) {
                dist[neighbor] = dist[node] + 1
                q.offer(neighbor)
            }
        }
    }

    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        val n = edges.size
        val dist1 = IntArray(n) { Int.MAX_VALUE }
        val dist2 = IntArray(n) { Int.MAX_VALUE }

        bfs(node1, edges, dist1)
        bfs(node2, edges, dist2)

        var minDistNode = -1
        var minMaxDist = Int.MAX_VALUE

        for (i in 0 until n) {
            val d1 = dist1[i]
            val d2 = dist2[i]
            if (d1 != Int.MAX_VALUE && d2 != Int.MAX_VALUE) {
                val maxDist = maxOf(d1, d2)
                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist
                    minDistNode = i
                }
            }
        }

        return minDistNode
    }
}
