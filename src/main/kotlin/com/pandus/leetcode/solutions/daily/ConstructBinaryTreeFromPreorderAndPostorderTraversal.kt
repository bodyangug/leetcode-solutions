package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? =
        if (pre.isEmpty()) null else TreeNode(pre[0]).apply {
            if (pre.size > 1) {
                val l = pre.size - 1
                val j = post.indexOf(pre[1]) + 1
                left = constructFromPrePost(pre.sliceArray(1..j), post.sliceArray(0..j))
                right = constructFromPrePost(pre.sliceArray(j + 1..l), post.sliceArray(j..<l))
            }
        }
}
