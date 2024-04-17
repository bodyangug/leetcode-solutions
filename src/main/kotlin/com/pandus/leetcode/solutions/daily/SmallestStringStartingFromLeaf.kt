package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

//Reference: https://leetcode.com/problems/smallest-string-starting-from-leaf
class SmallestStringStartingFromLeaf {

    private var smallestString = ""

    fun smallestFromLeaf(root: TreeNode?): String {
        dfs(root, "")
        return smallestString
    }

    fun dfs(root: TreeNode?, currentString: String) {
        root?.let {
            val newString = (root.`val` + 'a'.code).toChar() + currentString

            if (root.left == null && root.right == null) {
                if (smallestString.isEmpty() || smallestString > newString) {
                    smallestString = newString
                }
            }
            dfs(root.left, newString)
            dfs(root.right, newString)
        }
    }
}

