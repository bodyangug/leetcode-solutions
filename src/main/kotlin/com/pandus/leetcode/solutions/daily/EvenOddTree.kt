package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import java.util.LinkedList

// Reference: https://leetcode.com/problems/even-odd-tree
class EvenOddTree {

    // key - level 0..n
    // value - list of values from left to right
    private val levels = LinkedHashMap<Int, LinkedList<Int>>()

    fun isEvenOddTree(root: TreeNode?): Boolean {
        // 1. build map of levels
        root?.let {
            dfs(it, 0)
        }

        // 2. check values on each levels
        for (entry in levels.entries) {
            if (entry.key % 2 == 0) {
                // check even rule
                var prevEven = Int.MIN_VALUE
                for (i in entry.value) {
                    if (i <= prevEven || i % 2 == 0) return false
                    prevEven = i
                }
            } else {
                // check odd rule
                var prevOdd = Int.MAX_VALUE
                for (i in entry.value) {
                    if (i >= prevOdd || i % 2 == 1) return false
                    prevOdd = i
                }
            }
        }
        return true
    }

    private fun dfs(node: TreeNode, level: Int) {
        levels.getOrPut(level) { LinkedList() }.add(node.`val`)
        node.left?.let { dfs(it, level + 1) }
        node.right?.let { dfs(it, level + 1) }
    }
}
