package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/minimum-height-trees
class MinimumHeightTrees {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n < 2) {
            val centroids = ArrayList<Int>()
            for (i in 0 until n) centroids.add(i)
            return centroids
        }

        val neighbors = ArrayList<MutableSet<Int>>()
        for (i in 0 until n) neighbors.add(HashSet())

        for (edge in edges) {
            val start = edge[0]
            val end = edge[1]
            neighbors[start].add(end)
            neighbors[end].add(start)
        }

        var leaves = ArrayList<Int>()
        for (i in 0 until n) if (neighbors[i].size == 1) leaves.add(i)

        var remainingNodes = n
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size
            val newLeaves = ArrayList<Int>()

            for (leaf in leaves) {
                val neighbor = neighbors[leaf].iterator().next()
                neighbors[neighbor].remove(leaf)
                if (neighbors[neighbor].size == 1) newLeaves.add(neighbor)
            }
            leaves = newLeaves
        }
        return leaves
    }
}
