package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities
class MinimumScoreOfPathBetweenTwoCities {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (road in roads) {
            val u = road[0]
            val v = road[1]
            val score = road[2]
            graph.computeIfAbsent(u) { mutableListOf() }.add(Pair(v, score))
            graph.computeIfAbsent(v) { mutableListOf() }.add(Pair(u, score))
        }

        val visited = BooleanArray(n + 1)
        var minScore = Int.MAX_VALUE

        fun dfs(city: Int) {
            visited[city] = true
            for ((neighbor, score) in graph[city] ?: emptyList()) {
                minScore = minOf(minScore, score)
                if (!visited[neighbor]) {
                    dfs(neighbor)
                }
            }
        }

        dfs(1)
        return minScore
    }
}
