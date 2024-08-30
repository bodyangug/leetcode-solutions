package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sum-of-distances-in-tree
class SumOfDistancesInTree {
    private lateinit var ans: IntArray
    private lateinit var count: IntArray
    private lateinit var graph: MutableList<MutableSet<Int>>
    private var n: Int = 0

    fun sumOfDistancesInTree(N: Int, edges: Array<IntArray>): IntArray {
        this.n = N
        this.ans = IntArray(N)
        this.count = IntArray(N) { 1 }
        this.graph = ArrayList()

        repeat(N) {
            graph.add(HashSet())
        }

        edges.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }

        dfs(0, -1)
        dfs2(0, -1)
        return ans
    }

    fun dfs(node: Int, parent: Int) {
        for (child in graph[node]) {
            if (child != parent) {
                dfs(child, node)
                count[node] += count[child]
                ans[node] += ans[child] + count[child]
            }
        }
    }

    fun dfs2(node: Int, parent: Int) {
        for (child in graph[node]) {
            if (child != parent) {
                ans[child] = ans[node] - count[child] + n - count[child]
                dfs2(child, node)
            }
        }
    }
}
