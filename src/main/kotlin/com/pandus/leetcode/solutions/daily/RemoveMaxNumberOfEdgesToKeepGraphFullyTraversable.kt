package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        val dsBoth = IntArray(n + 1) { -1 }
        var used = 0

        fun find(ds: IntArray, i: Int): Int = if (ds[i] < 0) i else find(ds, ds[i]).also { ds[i] = it }

        for (tp in 3 downTo 1) {
            val ds = if (tp == 3) dsBoth else dsBoth.clone()
            edges.forEach { e ->
                if (e[0] == tp) {
                    var i = find(ds, e[1])
                    var j = find(ds, e[2])
                    if (i != j) {
                        used++
                        if (ds[j] < ds[i]) i = j.also { j = i }
                        ds[i] += ds[j]
                        ds[j] = i
                    }
                }
            }
            if (tp != 3 && ds[find(ds, 1)] != -n) return -1
        }
        return edges.size - used
    }
}
