package com.pandus.leetcode.solutions.daily

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

// Reference: https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups
class DivideNodesIntoTheMaximumNumberOfGroups {
    fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
        val adjList: MutableList<MutableList<Int>> = ArrayList()
        for (i in 0 until n) {
            adjList.add(ArrayList())
        }
        val parent = IntArray(n) { -1 }
        val depth = IntArray(n)

        // Build the adjacency list and apply Union-Find for each edge
        for (edge: IntArray in edges) {
            adjList[edge[0] - 1].add(edge[1] - 1)
            adjList[edge[1] - 1].add(edge[0] - 1)
            union(edge[0] - 1, edge[1] - 1, parent, depth)
        }

        val numOfGroupsForComponent: MutableMap<Int, Int> = HashMap()

        // For each node, calculate the maximum number of groups for its component
        for (node in 0 until n) {
            val numberOfGroups: Int = getNumberOfGroups(adjList, node, n)
            if (numberOfGroups == -1) return -1 // If invalid split, return -1

            val rootNode: Int = find(node, parent)
            numOfGroupsForComponent[rootNode] = max(
                numOfGroupsForComponent.getOrDefault(rootNode, 0),
                numberOfGroups
            )
        }

        // Calculate the total number of groups across all components
        var totalNumberOfGroups = 0
        for (numberOfGroups: Int in numOfGroupsForComponent.values) {
            totalNumberOfGroups += numberOfGroups
        }
        return totalNumberOfGroups
    }

    // Function to calculate the number of groups for a given component starting from srcNode
    private fun getNumberOfGroups(
        adjList: List<MutableList<Int>>,
        srcNode: Int,
        n: Int
    ): Int {
        val nodesQueue: Queue<Int> = LinkedList()
        val layerSeen = IntArray(n) { -1 }
        nodesQueue.offer(srcNode)
        layerSeen[srcNode] = 0
        var deepestLayer = 0

        // Perform BFS to calculate the number of layers (groups)
        while (!nodesQueue.isEmpty()) {
            val numOfNodesInLayer: Int = nodesQueue.size
            for (i in 0 until numOfNodesInLayer) {
                val currentNode: Int = nodesQueue.poll()
                for (neighbor: Int in adjList[currentNode]) {
                    // If neighbor hasn't been visited, assign it to the next layer
                    if (layerSeen[neighbor] == -1) {
                        layerSeen[neighbor] = deepestLayer + 1
                        nodesQueue.offer(neighbor)
                    } else {
                        // If the neighbor is already in the same layer, return -1 (invalid partition)
                        if (layerSeen[neighbor] == deepestLayer) {
                            return -1
                        }
                    }
                }
            }
            deepestLayer++
        }
        return deepestLayer
    }

    // Find the root of the given node in the Union-Find structure
    private fun find(node: Int, parent: IntArray): Int {
        var node: Int = node
        while (parent[node] != -1) node = parent[node]
        return node
    }

    // Union operation to merge two sets
    private fun union(node1: Int, node2: Int, parent: IntArray, depth: IntArray) {
        var node1: Int = node1
        var node2: Int = node2
        node1 = find(node1, parent)
        node2 = find(node2, parent)

        // If both nodes already belong to the same set, no action needed
        if (node1 == node2) return

        // Union by rank (depth) to keep the tree balanced
        if (depth[node1] < depth[node2]) {
            val temp: Int = node1
            node1 = node2
            node2 = temp
        }
        parent[node2] = node1

        // If the depths are equal, increment the depth of the new root
        if (depth[node1] == depth[node2]) depth[node1]++
    }
}
