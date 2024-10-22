package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

// Reference: https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree
class KthLargestSumInBinaryTree {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        val pq = PriorityQueue<Long>()
        val bfsQueue: Queue<TreeNode?> = LinkedList()
        bfsQueue.add(root)
        while (!bfsQueue.isEmpty()) {
            val size = bfsQueue.size
            var sum: Long = 0
            for (i in 0 until size) {
                val poppedNode = bfsQueue.remove()
                sum += poppedNode!!.`val`
                if (poppedNode.left != null) {
                    bfsQueue.add(poppedNode.left)
                }
                if (poppedNode.right != null) {
                    bfsQueue.add(poppedNode.right)
                }
            }
            pq.add(sum)
            if (pq.size > k) {
                pq.remove()
            }
        }
        if (pq.size < k) return -1
        return pq.peek()
    }
}
