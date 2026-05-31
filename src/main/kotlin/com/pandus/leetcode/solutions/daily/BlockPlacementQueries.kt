package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/block-placement-queries
class BlockPlacementQueries {
    fun getResults(queries: Array<IntArray>): List<Boolean> {
        val positions = sortedSetOf(0)
        for (q in queries) positions.add(q[1])
        val posList = positions.toList()
        val posToIdx = HashMap<Int, Int>(posList.size * 2)
        for ((i, p) in posList.withIndex()) posToIdx[p] = i

        val n = posList.size
        val tree = IntArray(4 * n)
        val obstacles = java.util.TreeSet<Int>()
        obstacles.add(0)

        val results = mutableListOf<Boolean>()
        for (query in queries) {
            if (query[0] == 1) {
                val x = query[1]
                val prev = obstacles.lower(x)!!
                val next = obstacles.higher(x)
                obstacles.add(x)
                update(tree, 1, 0, n - 1, posToIdx[x]!!, x - prev)
                if (next != null) {
                    update(tree, 1, 0, n - 1, posToIdx[next]!!, next - x)
                }
            } else {
                val x = query[1]
                val sz = query[2]
                val idx = posToIdx[x]!!
                val maxInTree = query(tree, 1, 0, n - 1, 0, idx)
                val lastObs = obstacles.floor(x)!!
                results.add(maxOf(maxInTree, x - lastObs) >= sz)
            }
        }
        return results
    }

    private fun update(tree: IntArray, node: Int, start: Int, end: Int, idx: Int, value: Int) {
        if (start == end) {
            tree[node] = value; return
        }
        val mid = (start + end) / 2
        if (idx <= mid) update(tree, 2 * node, start, mid, idx, value)
        else update(tree, 2 * node + 1, mid + 1, end, idx, value)
        tree[node] = maxOf(tree[2 * node], tree[2 * node + 1])
    }

    private fun query(tree: IntArray, node: Int, start: Int, end: Int, l: Int, r: Int): Int {
        if (r < start || end < l) return 0
        if (l <= start && end <= r) return tree[node]
        val mid = (start + end) / 2
        return maxOf(query(tree, 2 * node, start, mid, l, r), query(tree, 2 * node + 1, mid + 1, end, l, r))
    }
}
