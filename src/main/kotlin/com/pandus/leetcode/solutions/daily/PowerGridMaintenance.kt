package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/power-grid-maintenance
class PowerGridMaintenance {
    fun processQueries(c: Int, connections: Array<IntArray>, queries: Array<IntArray>): IntArray {
        // Build adjacency list
        val graph = Array(c + 1) { mutableListOf<Int>() }
        for ((a, b) in connections) {
            graph[a].add(b)
            graph[b].add(a)
        }

        // Find connected components using DFS
        val componentIds = IntArray(c + 1)
        val visited = BooleanArray(c + 1)
        val components = mutableMapOf<Int, TreeSet<Int>>()

        fun dfs(node: Int, compId: Int) {
            visited[node] = true
            componentIds[node] = compId
            components.getOrPut(compId) { TreeSet() }.add(node)
            for (neighbor in graph[node]) {
                if (!visited[neighbor]) dfs(neighbor, compId)
            }
        }
        for (i in 1..c) if (!visited[i]) dfs(i, i)

        // Track online status
        val online = BooleanArray(c + 1) { true }

        // Process queries
        return queries.mapNotNull { (operation, station) ->
            val compId = componentIds[station]
            val component = components[compId]!!
            when (operation) {
                2 -> {
                    component.remove(station)
                    online[station] = false
                    null
                }
                1 -> {
                    if (online[station]) station
                    else component.firstOrNull() ?: -1
                }
                else -> null
            }
        }.toIntArray()
    }
}
