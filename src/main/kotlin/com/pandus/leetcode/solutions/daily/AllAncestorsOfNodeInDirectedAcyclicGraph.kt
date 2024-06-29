package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph
class AllAncestorsOfNodeInDirectedAcyclicGraph {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        // Initialize adjacency list for the graph
        val adjacencyList = Array(n) { mutableListOf<Int>() }

        // Populate the adjacency list with reversed edges
        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]
            adjacencyList[to].add(from)
        }

        val ancestorsList = mutableListOf<MutableList<Int>>()

        // For each node, find all its ancestors (children in reversed graph)
        for (i in 0 until n) {
            val ancestors = mutableListOf<Int>()
            val visited = mutableSetOf<Int>()
            findChildren(i, adjacencyList, visited)
            // Add visited nodes to the current nodes' ancestor list
            for (node in 0 until n) {
                if (node == i) continue
                if (visited.contains(node)) ancestors.add(node)
            }
            ancestorsList.add(ancestors)
        }

        return ancestorsList
    }

    // Helper method to perform DFS and find all children of a given node
    private fun findChildren(
        currentNode: Int,
        adjacencyList: Array<MutableList<Int>>,
        visitedNodes: MutableSet<Int>
    ) {
        // Mark current node as visited
        visitedNodes.add(currentNode)

        // Recursively traverse all neighbors
        for (neighbour in adjacencyList[currentNode]) {
            if (!visitedNodes.contains(neighbour)) {
                findChildren(neighbour, adjacencyList, visitedNodes)
            }
        }
    }
}