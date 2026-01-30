package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-cost-to-convert-string-ii
class MinimumCostToConvertStringII {
    private class TrieNode {
        val children = arrayOfNulls<TrieNode>(ALPHABET_SIZE)
        var wordId: Int = NO_ID

        companion object {
            private const val ALPHABET_SIZE = 26
            private const val NO_ID = -1
        }
    }

    fun minimumCost(
        source: String,
        target: String,
        original: Array<String>,
        changed: Array<String>,
        cost: IntArray
    ): Long {
        val root = TrieNode()
        var nextId = 0
        val maxNodes = original.size * 2
        val distanceGraph = Array(maxNodes) { row ->
            IntArray(maxNodes) { col -> if (row == col) 0 else INF }
        }

        fun insertWord(word: String): Int {
            var current = root
            for (char in word) {
                val index = char - 'a'
                current = current.children[index] ?: TrieNode().also { current.children[index] = it }
            }
            if (current.wordId == -1) {
                current.wordId = nextId++
            }
            return current.wordId
        }

        // Build graph from transformation rules
        for (i in original.indices) {
            val fromId = insertWord(original[i])
            val toId = insertWord(changed[i])
            distanceGraph[fromId][toId] = min(distanceGraph[fromId][toId], cost[i])
        }

        // Floyd-Warshall to compute shortest paths between all word pairs
        for (k in 0 until nextId) {
            for (i in 0 until nextId) {
                for (j in 0 until nextId) {
                    distanceGraph[i][j] = min(distanceGraph[i][j], distanceGraph[i][k] + distanceGraph[k][j])
                }
            }
        }

        // DP to find minimum cost to convert source to target
        val n = source.length
        val minCost = LongArray(n) { NOT_REACHABLE }

        for (startPos in 0 until n) {
            if (startPos > 0 && minCost[startPos - 1] == NOT_REACHABLE) continue

            val baseCost = if (startPos == 0) 0L else minCost[startPos - 1]

            // If characters match, we can skip without cost
            if (source[startPos] == target[startPos]) {
                minCost[startPos] = minOf(minCost[startPos].takeIf { it != NOT_REACHABLE } ?: Long.MAX_VALUE, baseCost)
            }

            // Try all substrings starting at startPos
            var sourceNode: TrieNode? = root
            var targetNode: TrieNode? = root

            for (endPos in startPos until n) {
                sourceNode = sourceNode?.children[source[endPos] - 'a']
                targetNode = targetNode?.children[target[endPos] - 'a']

                if (sourceNode == null || targetNode == null) break

                val sourceId = sourceNode.wordId
                val targetId = targetNode.wordId

                if (sourceId != -1 && targetId != -1 && distanceGraph[sourceId][targetId] != INF) {
                    val newCost = baseCost + distanceGraph[sourceId][targetId]
                    if (minCost[endPos] == NOT_REACHABLE || newCost < minCost[endPos]) {
                        minCost[endPos] = newCost
                    }
                }
            }
        }

        return minCost[n - 1]
    }

    companion object {
        private const val INF = Int.MAX_VALUE / 2
        private const val NOT_REACHABLE = -1L
    }
}
