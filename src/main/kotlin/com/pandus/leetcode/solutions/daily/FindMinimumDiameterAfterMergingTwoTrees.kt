package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees
class FindMinimumDiameterAfterMergingTwoTrees {
    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
        val graphs = listOf(edges1, edges2).map { edges ->
            mutableMapOf<Int, MutableList<Int>>().apply {
                for ((a, b) in edges) {
                    getOrPut(a) { mutableListOf() }.add(b)
                    getOrPut(b) { mutableListOf() }.add(a)
                }
            }
        }

        val diameter1 = findDiameter(graphs[0])
        val diameter2 = findDiameter(graphs[1])

        return maxOf(diameter1, diameter2, (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1)
    }

    private fun findDiameter(graph: Map<Int, List<Int>>): Int {
        val (farthestNode, _) = bfs(0, graph)
        return bfs(farthestNode, graph).second
    }

    private fun bfs(start: Int, graph: Map<Int, List<Int>>): Pair<Int, Int> {
        val queue = ArrayDeque<Int>().apply { add(start) }
        val visited = mutableMapOf<Int, Int>().apply { this[start] = 0 }
        var farthestNode = start
        var maxDistance = 0

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val currentDistance = visited[current] ?: 0

            for (neighbor in graph[current] ?: emptyList()) {
                if (neighbor !in visited) {
                    visited[neighbor] = currentDistance + 1
                    queue.add(neighbor)

                    if (currentDistance + 1 > maxDistance) {
                        maxDistance = currentDistance + 1
                        farthestNode = neighbor
                    }
                }
            }
        }
        return farthestNode to maxDistance
    }
}
