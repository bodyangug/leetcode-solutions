package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import java.util.*

// Reference: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
class BinarySearchTreeToGreaterSumTree {
    fun bstToGst(root: TreeNode?): TreeNode? {
        // Store the inorder traversal in an array.
        val inorderTraversal: MutableList<Int> = ArrayList()
        inorder(root, inorderTraversal)

        // Reverse the array to get descending order.
        inorderTraversal.reverse()

        // Modify the values in the tree.
        replaceValues(root, inorderTraversal)
        return root
    }

    // Perform any traversal of your choice to store node values.
    private fun inorder(root: TreeNode?, inorderTraversal: MutableList<Int>) {
        if (root == null) {
            return
        }
        inorder(root.left, inorderTraversal)
        inorderTraversal.add(root.`val`)
        inorder(root.right, inorderTraversal)
    }

    // Function to modify the values in the tree.
    private fun replaceValues(root: TreeNode?, inorderTraversal: MutableList<Int>) {
        if (root == null) {
            return
        }
        replaceValues(root.left, inorderTraversal)
        replaceValues(root.right, inorderTraversal)
        var nodeSum = 0
        // Replace node with values greater than the current value.
        for (i in inorderTraversal) {
            nodeSum += if (i > root.`val`) {
                i
            } else {
                break
            }
        }
        root.`val` += nodeSum
    }
}
