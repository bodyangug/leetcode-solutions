package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
class PseudoPalindromicPathsInBinaryTree {
    private var count: Int = 0

    private fun preorder(node: TreeNode?, path: Int) {
        node?.let {
            val pathXor = path xor (1 shl it.`val`)

            if (it.left == null && it.right == null) {
                if (pathXor and (pathXor - 1) == 0) {
                    ++count
                }
            }
            preorder(it.left, pathXor)
            preorder(it.right, pathXor)
        }
    }

    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        preorder(root, 0)
        return count
    }
}
