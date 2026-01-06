package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import java.util.*

// Reference: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree
class MaximumLevelSumOfBinaryTree {
    fun maxLevelSum(root: TreeNode?): Int {
        var maxSum = Int.MIN_VALUE
        var ans = 0
        var level = 0
        val q: Queue<TreeNode> = LinkedList()
        q.offer(root)
        while (!q.isEmpty()) {
            level++
            var sumAtCurrentLevel = 0
            // Iterate over all the nodes in the current level.
            for (sz in q.size downTo 1) {
                val node = q.poll()
                sumAtCurrentLevel += node.`val`

                if (node.left != null) {
                    q.offer(node.left)
                }
                if (node.right != null) {
                    q.offer(node.right)
                }
            }
            if (maxSum < sumAtCurrentLevel) {
                maxSum = sumAtCurrentLevel
                ans = level
            }
        }
        return ans
    }
}
