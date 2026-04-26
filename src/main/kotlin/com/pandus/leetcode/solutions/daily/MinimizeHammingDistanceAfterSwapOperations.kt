package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations
class MinimizeHammingDistanceAfterSwapOperations {
    fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val n = source.size
        val graph = Array(n) { mutableListOf<Int>() }
        for (swap in allowedSwaps) {
            graph[swap[0]].add(swap[1])
            graph[swap[1]].add(swap[0])
        }

        val visited = BooleanArray(n)
        var hammingDistance = 0

        for (i in 0 until n) {
            if (!visited[i]) {
                val indices = mutableListOf<Int>()
                dfs(i, graph, visited, indices)

                val sourceCount = mutableMapOf<Int, Int>()
                val targetCount = mutableMapOf<Int, Int>()

                for (index in indices) {
                    sourceCount[source[index]] = sourceCount.getOrDefault(source[index], 0) + 1
                    targetCount[target[index]] = targetCount.getOrDefault(target[index], 0) + 1
                }

                for ((num, count) in sourceCount) {
                    hammingDistance += maxOf(0, count - targetCount.getOrDefault(num, 0))
                }
            }
        }

        return hammingDistance
    }

    private fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray, indices: MutableList<Int>) {
        visited[node] = true
        indices.add(node)
        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, indices)
            }
        }
    }
}
