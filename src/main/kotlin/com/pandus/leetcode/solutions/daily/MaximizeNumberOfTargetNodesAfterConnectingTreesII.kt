package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii
class MaximizeNumberOfTargetNodesAfterConnectingTreesII {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
        val n = edges1.size + 1
        val m = edges2.size + 1

        val color1 = IntArray(n)
        val color2 = IntArray(m)

        val count1 = build(edges1, color1)
        val count2 = build(edges2, color2)

        val maxColor2 = max(count2[0], count2[1])
        return IntArray(n) { count1[color1[it]] + maxColor2 }
    }

    private fun build(edges: Array<IntArray>, color: IntArray): IntArray {
        val n = color.size
        val adj = List(n) { mutableListOf<Int>() }

        for ((u, v) in edges) {
            adj[u].add(v)
            adj[v].add(u)
        }

        val countColor0 = dfs(0, -1, 0, adj, color)
        return intArrayOf(countColor0, n - countColor0)
    }

    private fun dfs(
        node: Int,
        parent: Int,
        depth: Int,
        adj: List<List<Int>>,
        color: IntArray
    ): Int {
        color[node] = depth % 2
        var count = 1 - color[node]

        for (neighbor in adj[node]) {
            if (neighbor != parent) {
                count += dfs(neighbor, node, depth + 1, adj, color)
            }
        }
        return count
    }
}
