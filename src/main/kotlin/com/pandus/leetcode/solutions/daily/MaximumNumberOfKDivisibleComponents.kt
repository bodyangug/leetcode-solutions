package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-number-of-k-divisible-components
class MaximumNumberOfKDivisibleComponents {
    private var count = 0
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        if (n == 1) return 1
        val connections = mutableMapOf<Int, MutableSet<Int>>()
        for ((a, b) in edges) {
            connections.computeIfAbsent(a) { mutableSetOf() }.add(b)
            connections.computeIfAbsent(b) { mutableSetOf() }.add(a)
        }
        val visited = mutableSetOf<Int>(0)
        dfs(connections, values, k, 0, visited)
        return count
    }

    private fun dfs(
        connections: MutableMap<Int, MutableSet<Int>>,
        values: IntArray,
        k: Int,
        node: Int,
        visited: MutableSet<Int>
    ): Int {
        var childValue = 0
        if (node in connections) {
            for (nextNode in connections[node]!!) {
                if (nextNode !in visited) {
                    visited.add(node)
                    childValue += dfs(connections, values, k, nextNode, visited)
                }
            }
        }
        val value = (values[node] + childValue)
        return if (value % k == 0) {
            count++
            0
        } else {
            value % k
        }
    }
}
