package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i
class MaximizeNumberOfTargetNodesAfterConnectingTreesI {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
        val n = edges1.size + 1
        val count1 = build(edges1, k)
        val maxCount2 = build(edges2, k - 1).maxOrNull() ?: 0
        return IntArray(n) { count1[it] + maxCount2 }
    }

    private fun build(edges: Array<IntArray>, k: Int): IntArray {
        val n = edges.size + 1
        val children = List(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            children[u].add(v)
            children[v].add(u)
        }
        return IntArray(n) { dfs(it, -1, children, k) }
    }

    private fun dfs(node: Int, parent: Int, children: List<List<Int>>, k: Int): Int {
        if (k < 0) return 0
        var res = 1
        for (child in children[node]) {
            if (child != parent) {
                res += dfs(child, node, children, k - 1)
            }
        }
        return res
    }
}
