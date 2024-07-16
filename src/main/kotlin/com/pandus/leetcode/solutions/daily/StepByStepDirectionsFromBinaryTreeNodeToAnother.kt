package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

//Reference: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another
class StepByStepDirectionsFromBinaryTreeNodeToAnother {
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        val lowestCommonAncestor: TreeNode? = findLowestCommonAncestor(root, startValue, destValue)

        val pathToStart = StringBuilder()
        val pathToDest = StringBuilder()

        // Find paths from LCA to start and destination nodes
        findPath(lowestCommonAncestor, startValue, pathToStart)
        findPath(lowestCommonAncestor, destValue, pathToDest)

        val directions = StringBuilder()
        // Add "U" for each step to go up from start to LCA
        directions.append("U".repeat(pathToStart.length))
        // Append the path from LCA to destination
        directions.append(pathToDest)
        return directions.toString()
    }

    private fun findLowestCommonAncestor(
        node: TreeNode?,
        value1: Int,
        value2: Int
    ): TreeNode? {
        if (node == null) return null

        if (node.`val` == value1 || node.`val` == value2) return node

        val leftLCA: TreeNode? = findLowestCommonAncestor(node.left, value1, value2)
        val rightLCA: TreeNode? = findLowestCommonAncestor(node.right, value1, value2)
        return if (leftLCA == null) rightLCA
        else if (rightLCA == null) leftLCA
        else node // Both values found, this is the LCA
    }

    private fun findPath(
        node: TreeNode?,
        targetValue: Int,
        path: StringBuilder
    ): Boolean {
        if (node == null) return false
        if (node.`val` == targetValue) return true

        // Try left subtree
        path.append("L")
        if (findPath(node.left, targetValue, path)) return true
        path.setLength(path.length - 1) // Remove last character

        // Try right subtree
        path.append("R")
        if (findPath(node.right, targetValue, path)) return true
        path.setLength(path.length - 1) // Remove last character

        return false
    }
}