package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import kotlin.math.max

// Reference: https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries
class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    private val maxHeightAfterRemoval: IntArray = IntArray(100001)
    private var currentMaxHeight: Int = 0

    fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
        traverseLeftToRight(root, 0)
        currentMaxHeight = 0
        traverseRightToLeft(root, 0)

        val queryCount = queries.size
        val queryResults = IntArray(queryCount)
        for (i in 0 until queryCount) {
            queryResults[i] = maxHeightAfterRemoval[queries[i]]
        }
        return queryResults
    }

    private fun traverseLeftToRight(node: TreeNode?, currentHeight: Int) {
        if (node == null) return

        maxHeightAfterRemoval[node.`val`] = currentMaxHeight
        currentMaxHeight = max(currentMaxHeight, currentHeight)

        traverseLeftToRight(node.left, currentHeight + 1)
        traverseLeftToRight(node.right, currentHeight + 1)
    }

    private fun traverseRightToLeft(node: TreeNode?, currentHeight: Int) {
        if (node == null) return

        maxHeightAfterRemoval[node.`val`] = max(maxHeightAfterRemoval[node.`val`], currentMaxHeight)
        currentMaxHeight = max(currentHeight, currentMaxHeight)

        traverseRightToLeft(node.right, currentHeight + 1)
        traverseRightToLeft(node.left, currentHeight + 1)
    }
}
