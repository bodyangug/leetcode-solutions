package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/recover-a-tree-from-preorder-traversal
class RecoverTreeFromPreorderTraversal {
    fun recoverFromPreorder(traversal: String): TreeNode? {
        val stack = mutableListOf<TreeNode>()
        var i = 0
        while (i < traversal.length) {
            var level = 0
            // Count dashes to determine the depth of the current node
            while (i < traversal.length && traversal[i] == '-') {
                level++
                i++
            }
            // Extract the integer value
            val start = i
            while (i < traversal.length && traversal[i].isDigit()) {
                i++
            }
            val value = traversal.substring(start, i).toInt()
            val node = TreeNode(value)

            // Ensure the stack represents the correct tree depth
            while (stack.size > level) {
                stack.removeAt(stack.lastIndex)
            }
            // Attach the new node as a child
            if (stack.isNotEmpty()) {
                val parent = stack.last()
                if (parent.left == null) {
                    parent.left = node
                } else {
                    parent.right = node
                }
            }
            stack.add(node)
        }
        return stack.firstOrNull()
    }
}
