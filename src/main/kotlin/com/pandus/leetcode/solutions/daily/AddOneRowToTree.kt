package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/add-one-row-to-tree
class AddOneRowToTree {
    fun addOneRow(
        t: TreeNode?,
        v: Int,
        d: Int
    ): TreeNode? {
        if (d == 1) {
            val n = TreeNode(v)
            n.left = t
            return n
        }
        insert(numToInsert = v, node = t, curDepth = 1, targetDepth = d)
        return t
    }

    private fun insert(
        numToInsert: Int,
        node: TreeNode?,
        curDepth: Int,
        targetDepth: Int
    ) {
        if (node == null) return
        if (curDepth == targetDepth - 1) {
            // insert left
            node.left?.let {
                val t = it
                node.left = TreeNode(numToInsert).apply { left = t }
            }
            // insert right
            node.right?.let {
                val t = it
                node.right = TreeNode(numToInsert).apply { right = t }
            }
        } else {
            insert(numToInsert, node.left, curDepth + 1, targetDepth)
            insert(numToInsert, node.right, curDepth + 1, targetDepth)
        }
    }
}
