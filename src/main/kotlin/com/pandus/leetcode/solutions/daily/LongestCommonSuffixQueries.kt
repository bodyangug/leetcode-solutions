package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-common-suffix-queries
class LongestCommonSuffixQueries {
    private class TrieNode {
        val children = arrayOfNulls<TrieNode>(26)
        var bestIndex = -1
        var bestLength = Int.MAX_VALUE
    }

    fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        val root = TrieNode()

        for (i in wordsContainer.indices) {
            val word = wordsContainer[i]
            updateBest(root, i, word.length)
            var node = root
            for (j in word.length - 1 downTo 0) {
                val c = word[j] - 'a'
                if (node.children[c] == null) {
                    node.children[c] = TrieNode()
                }
                node = node.children[c]!!
                updateBest(node, i, word.length)
            }
        }

        val result = IntArray(wordsQuery.size)
        for (i in wordsQuery.indices) {
            val query = wordsQuery[i]
            var node = root
            for (j in query.length - 1 downTo 0) {
                val c = query[j] - 'a'
                if (node.children[c] == null) break
                node = node.children[c]!!
            }
            result[i] = node.bestIndex
        }
        return result
    }

    private fun updateBest(node: TrieNode, index: Int, length: Int) {
        if (node.bestIndex == -1 || length < node.bestLength) {
            node.bestIndex = index
            node.bestLength = length
        }
    }
}
