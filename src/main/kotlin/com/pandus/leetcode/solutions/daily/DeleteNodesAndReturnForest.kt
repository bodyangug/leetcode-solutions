package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/delete-nodes-and-return-forest
class DeleteNodesAndReturnForest {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        var root = root
        val toDeleteSet: MutableSet<Int> = HashSet()
        for (`val` in to_delete) {
            toDeleteSet.add(`val`)
        }
        val forest: MutableList<TreeNode?> = ArrayList()

        root = processNode(root, toDeleteSet, forest)

        // If the root is not deleted, add it to the forest
        if (root != null) {
            forest.add(root)
        }

        return forest
    }

    private fun processNode(
        node: TreeNode?,
        toDeleteSet: Set<Int>,
        forest: MutableList<TreeNode?>
    ): TreeNode? {
        if (node == null) {
            return null
        }

        node.left = processNode(node.left, toDeleteSet, forest)
        node.right = processNode(node.right, toDeleteSet, forest)

        // Node Evaluation: Check if the current node needs to be deleted
        if (toDeleteSet.contains(node.`val`)) {
            // If the node has left or right children, add them to the forest
            if (node.left != null) {
                forest.add(node.left)
            }
            if (node.right != null) {
                forest.add(node.right)
            }
            // Return null to its parent to delete the current node
            return null
        }
        return node
    }
}
