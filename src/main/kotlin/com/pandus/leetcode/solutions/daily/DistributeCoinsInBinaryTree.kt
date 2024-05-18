package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode
import kotlin.math.abs

//Reference: https://leetcode.com/problems/distribute-coins-in-binary-tree
class DistributeCoinsInBinaryTree {
    private var moves = 0

    fun distributeCoins(root: TreeNode?): Int {
        moves = 0
        dfs(root)
        return moves
    }

    private fun dfs(current: TreeNode?): Int {
        if (current == null) return 0

        // Calculate the coins each subtree has available to exchange
        val leftCoins = dfs(current.left)
        val rightCoins = dfs(current.right)

        // Add the total number of exchanges to moves
        moves += abs(leftCoins) + abs(rightCoins)

        // The number of coins current has available to exchange
        return (current.`val` - 1) + leftCoins + rightCoins
    }
}