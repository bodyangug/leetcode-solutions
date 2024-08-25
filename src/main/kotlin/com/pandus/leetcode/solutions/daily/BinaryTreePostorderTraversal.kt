package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import java.util.*


//Reference: https://leetcode.com/problems/binary-tree-postorder-traversal
class BinaryTreePostorderTraversal {
    private fun postorderTraversalHelper(currentNode: TreeNode?, result: MutableList<Int>) {
        if (currentNode == null) {
            return
        }
        postorderTraversalHelper(currentNode.left, result)
        postorderTraversalHelper(currentNode.right, result)
        result.add(currentNode.`val`)
    }

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result: MutableList<Int> = ArrayList()
        postorderTraversalHelper(root, result)
        return result
    }
}