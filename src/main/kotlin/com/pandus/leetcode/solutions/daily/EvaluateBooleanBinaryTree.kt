package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/evaluate-boolean-binary-tree
class EvaluateBooleanBinaryTree {
    fun evaluateTree(root: TreeNode): Boolean {
        // Handles the case for leaf nodes.
        if (root.left == null && root.right == null) {
            return root.`val` != 0
        }

        // Store the evaluations for the left subtree and right subtree.
        val evaluateLeftSubtree = evaluateTree(root.left!!)
        val evaluateRightSubtree = evaluateTree(root.right!!)
        val evaluateRoot = if (root.`val` == 2) {
            evaluateLeftSubtree or evaluateRightSubtree
        } else {
            evaluateLeftSubtree and evaluateRightSubtree
        }

        return evaluateRoot
    }
}
