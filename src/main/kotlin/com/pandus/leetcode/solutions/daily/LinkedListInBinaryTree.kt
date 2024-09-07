package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode
import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/linked-list-in-binary-tree
class LinkedListInBinaryTree {

    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        if (root == null) return false
        return dfs(head, root) ||
                isSubPath(head, root.left) ||
                isSubPath(head, root.right)
    }

    private fun dfs(head: ListNode?, root: TreeNode?): Boolean {
        if (head == null) return true // List is empty
        if (root == null) return false // Tree is empty
        if (root.`val` == head.`val`) {
            return dfs(head.next, root.left) || dfs(head.next, root.right)
        }
        return false
    }
}
