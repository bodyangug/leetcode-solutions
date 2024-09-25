package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sum-of-prefix-scores-of-strings
class SumOfPrefixScoresOfStrings {
    fun sumPrefixScores(words: Array<String>): IntArray {
        val root = Node()
        fun traversal(word: String) = word.runningFold(root, Node::traverse)
        return words
            .map(::traversal)
            .map { node -> node.sumOf(Node::count) }
            .toIntArray()
    }

    private class Node {
        val next = mutableMapOf<Char, Node>()
        var count = 0
        fun traverse(char: Char): Node = next.getOrPut(char, ::Node).apply { count++ }
    }
}
