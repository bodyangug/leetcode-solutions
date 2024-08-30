package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/balance-a-binary-search-tree
class BalanceBinarySearchTree {
    fun balanceBST(root: TreeNode?): TreeNode? {
        val inorder: MutableList<Int> = ArrayList()
        inorderTraversal(root, inorder)
        return createBalancedBST(inorder, 0, inorder.size - 1)
    }

    private fun inorderTraversal(root: TreeNode?, inorder: MutableList<Int>) {
        if (root == null) return
        inorderTraversal(root.left, inorder)
        inorder.add(root.`val`)
        inorderTraversal(root.right, inorder)
    }

    private fun createBalancedBST(
        inorder: List<Int>,
        start: Int,
        end: Int
    ): TreeNode? {
        if (start > end) return null
        // Find the middle element of the current range
        val mid = start + (end - start) / 2
        // Recursively construct the left and right subtrees
        val leftSubtree: TreeNode? = createBalancedBST(inorder, start, mid - 1)
        val rightSubtree: TreeNode? = createBalancedBST(inorder, mid + 1, end)
        // Create a new node with the middle element and attach the subtrees
        return TreeNode(
            inorder[mid],
            leftSubtree,
            rightSubtree
        )
    }
}
