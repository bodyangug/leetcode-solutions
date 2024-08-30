package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.Node

// Reference: https://leetcode.com/problems/n-ary-tree-postorder-traversal
class NaryTreePostorderTraversal {
    fun postorder(root: Node?): List<Int> {
        val result: MutableList<Int> = ArrayList()
        if (root == null) {
            return result
        }
        traversePostorder(root, result)
        return result
    }

    private fun traversePostorder(currentNode: Node?, postorderList: MutableList<Int>) {
        if (currentNode == null) {
            return
        }
        for (childNode in currentNode.children) {
            traversePostorder(childNode, postorderList)
        }
        postorderList.add(currentNode.`val`)
    }
}
