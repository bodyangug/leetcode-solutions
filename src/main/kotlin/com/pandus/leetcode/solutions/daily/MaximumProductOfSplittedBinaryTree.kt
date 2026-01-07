package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

// Reference: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree
class MaximumProductOfSplittedBinaryTree {
    private var maxProduct = 0L

    fun maxProduct(root: TreeNode?): Int {
        val totalSum = calculateTotalSum(root)
        maxProduct = 0L
        findMaxProduct(root, totalSum)
        return (maxProduct % 1_000_000_007).toInt()
    }

    private fun calculateTotalSum(node: TreeNode?): Long {
        if (node == null) return 0L
        val leftSum = calculateTotalSum(node.left)
        val rightSum = calculateTotalSum(node.right)
        return leftSum + rightSum + node.`val`
    }

    private fun findMaxProduct(node: TreeNode?, totalSum: Long): Long {
        if (node == null) return 0L
        val leftSum = findMaxProduct(node.left, totalSum)
        val rightSum = findMaxProduct(node.right, totalSum)
        val currentSum = leftSum + rightSum + node.`val`
        val product = currentSum * (totalSum - currentSum)
        maxProduct = maxOf(maxProduct, product)
        return currentSum
    }
}
