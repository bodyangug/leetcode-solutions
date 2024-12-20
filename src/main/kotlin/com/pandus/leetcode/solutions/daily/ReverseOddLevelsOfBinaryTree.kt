package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import java.util.LinkedList
import java.util.Queue

// Reference: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree
class ReverseOddLevelsOfBinaryTree {
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null // Return null if the tree is empty.
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root) // Start BFS with the root node.
        var level = 0

        while (!queue.isEmpty()) {
            val size = queue.size
            val currentLevelNodes: MutableList<TreeNode> = ArrayList<TreeNode>()

            // Process all nodes at the current level.
            for (i in 0 until size) {
                val node: TreeNode = queue.poll()
                currentLevelNodes.add(node)

                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
            }
            // Reverse node values if the current level is odd.
            if (level % 2 == 1) {
                var left = 0
                var right = currentLevelNodes.size - 1
                while (left < right) {
                    val temp: Int = currentLevelNodes[left].`val`
                    currentLevelNodes[left].`val` = currentLevelNodes[right].`val`
                    currentLevelNodes[right].`val` = temp
                    left++
                    right--
                }
            }

            level++
        }
        return root
    }
}
