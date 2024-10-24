package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/flip-equivalent-binary-trees
class FlipEquivalentBinaryTrees {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        // Both trees are empty
        if (root1 == null && root2 == null) {
            return true
        }
        // Just one of the trees is empty
        if (root1 == null || root2 == null) {
            return false
        }
        // Corresponding values differ
        if (root1.`val` != root2.`val`) {
            return false
        }

        // Check if corresponding subtrees are flip equivalent
        val noSwap =
            flipEquiv(root1.left, root2.left) &&
                    flipEquiv(root1.right, root2.right)
        // Check if opposite subtrees are flip equivalent
        val swap =
            flipEquiv(root1.left, root2.right) &&
                    flipEquiv(root1.right, root2.left)

        return noSwap || swap
    }
}
