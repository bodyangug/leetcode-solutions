package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import java.util.LinkedList
import java.util.Queue

// Reference: https://leetcode.com/problems/cousins-in-binary-tree-ii
class CousinsInBinaryTreeII {
    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        if (root == null) return root

        val nodeQueue: Queue<TreeNode?> = LinkedList()
        nodeQueue.offer(root)
        val levelSums: MutableList<Int> = ArrayList()

        // First BFS: Calculate sum of nodes at each level
        while (!nodeQueue.isEmpty()) {
            var levelSum = 0
            val levelSize = nodeQueue.size
            for (i in 0 until levelSize) {
                val currentNode = nodeQueue.poll()
                levelSum += currentNode!!.`val`
                if (currentNode.left != null)
                    nodeQueue.offer(currentNode.left)
                if (currentNode.right != null)
                    nodeQueue.offer(currentNode.right)
            }
            levelSums.add(levelSum)
        }

        // Second BFS: Update each node's value to sum of its cousins
        nodeQueue.offer(root)
        var levelIndex = 1
        root.`val` = 0 // Root has no cousins
        while (!nodeQueue.isEmpty()) {
            val levelSize = nodeQueue.size
            for (i in 0 until levelSize) {
                val currentNode = nodeQueue.poll()

                val siblingSum =
                    (if (currentNode!!.left != null) currentNode.left!!.`val` else 0) +
                            (if (currentNode.right != null) currentNode.right!!.`val` else 0)

                if (currentNode.left != null) {
                    currentNode.left!!.`val` = levelSums[levelIndex] - siblingSum
                    nodeQueue.offer(currentNode.left)
                }
                if (currentNode.right != null) {
                    currentNode.right!!.`val` = levelSums[levelIndex] - siblingSum
                    nodeQueue.offer(currentNode.right)
                }
            }
            ++levelIndex
        }
        return root
    }
}
