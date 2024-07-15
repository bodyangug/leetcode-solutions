package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode


//Reference: https://leetcode.com/problems/create-binary-tree-from-descriptions
class CreateBinaryTreeFromDescriptions {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val parentToChildren: MutableMap<Int, MutableList<IntArray>> = HashMap()
        val allNodes: MutableSet<Int> = HashSet()
        val children: MutableSet<Int> = HashSet()
        for (description in descriptions) {
            val parent = description[0]
            val child = description[1]
            val isLeft = description[2]

            if (!parentToChildren.containsKey(parent)) {
                parentToChildren[parent] = ArrayList()
            }
            parentToChildren[parent]!!.add(intArrayOf(child, isLeft))
            allNodes.add(parent)
            allNodes.add(child)
            children.add(child)
        }

        // Step 2: Find the root
        var rootVal = 0
        for (node in allNodes) {
            if (!children.contains(node)) {
                rootVal = node
                break
            }
        }

        // Step 3 & 4: Build the tree using DFS
        return dfs(parentToChildren, rootVal)
    }

    // DFS function to recursively build binary tree
    private fun dfs(parentToChildren: Map<Int, List<IntArray>>, `val`: Int): TreeNode {
        val node = TreeNode(`val`)

        // If current node has children, recursively build them
        if (parentToChildren.containsKey(`val`)) {
            for (childInfo in parentToChildren[`val`]!!) {
                val child = childInfo[0]
                val isLeft = childInfo[1]

                // Attach child node based on isLeft flag
                if (isLeft == 1) {
                    node.left = dfs(parentToChildren, child)
                } else {
                    node.right = dfs(parentToChildren, child)
                }
            }
        }
        return node
    }
}