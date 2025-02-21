package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree
class FindElementsInContaminatedBinaryTree(root: TreeNode?) {
    private var seen: HashSet<Int>? = null

    init {
        seen = HashSet()
        dfs(root, 0)
    }

    fun find(target: Int): Boolean {
        return seen!!.contains(target)
    }

    private fun dfs(currentNode: TreeNode?, currentValue: Int) {
        if (currentNode == null) return
        // visit current node by adding its value to seen
        seen!!.add(currentValue)
        dfs(currentNode.left, currentValue * 2 + 1)
        dfs(currentNode.right, currentValue * 2 + 2)
    }
}
