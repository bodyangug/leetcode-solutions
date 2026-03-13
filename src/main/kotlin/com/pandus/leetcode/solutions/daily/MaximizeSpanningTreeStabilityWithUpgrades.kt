package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades
class MaximizeSpanningTreeStabilityWithUpgrades {
    private class DSU(parent: IntArray) {
        val parent = parent.copyOf()

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun join(x: Int, y: Int) {
            val px = find(x)
            val py = find(y)
            parent[px] = py
        }
    }

    companion object {
        private const val MAX_STABILITY = 200_000
    }

    fun maxStability(n: Int, edges: Array<IntArray>, k: Int): Int {
        var ans = -1
        if (edges.size < n - 1) return -1

        val mustEdges = mutableListOf<IntArray>()
        val optionalEdges = mutableListOf<IntArray>()

        for (edge in edges) {
            if (edge[3] == 1) {
                mustEdges.add(edge)
            } else {
                optionalEdges.add(edge)
            }
        }

        if (mustEdges.size > n - 1) return -1

        optionalEdges.sortByDescending { it[2] }
        var selectedInit = 0
        var mustMinStability = MAX_STABILITY

        val initParent = IntArray(n) { it }
        val dsuInit = DSU(initParent)

        for (e in mustEdges) {
            val u = e[0]
            val v = e[1]
            val s = e[2]
            if (dsuInit.find(u) == dsuInit.find(v) || selectedInit == n - 1) {
                return -1
            }
            dsuInit.join(u, v)
            selectedInit++
            mustMinStability = minOf(mustMinStability, s)
        }

        var l = 0
        var r = mustMinStability
        while (l < r) {
            val mid = l + (r - l + 1) / 2

            val dsu = DSU(dsuInit.parent)
            var selected = selectedInit
            var doubledCount = 0

            for (e in optionalEdges) {
                val u = e[0]
                val v = e[1]
                val s = e[2]
                if (dsu.find(u) == dsu.find(v)) continue
                if (s >= mid) {
                    dsu.join(u, v)
                    selected++
                } else if (doubledCount < k && s * 2 >= mid) {
                    doubledCount++
                    dsu.join(u, v)
                    selected++
                } else {
                    break
                }
                if (selected == n - 1) break
            }

            if (selected != n - 1) {
                r = mid - 1
            } else {
                ans = mid
                l = mid
            }
        }
        return ans
    }
}
