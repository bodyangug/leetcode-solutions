package com.pandus.leetcode.solutions.daily

//Reference:https://leetcode.com/problems/leaf-similar-trees
class LeafSimilarTree {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leave1 = ArrayList<Int>()
        val leave2 = ArrayList<Int>()
        getLeaf(root1, leave1)
        getLeaf(root2, leave2)
        return leave1 == leave2
    }

    private fun getLeaf(root: TreeNode?, leave: MutableList<Int>) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leave.add(root.`val`)
            }
            getLeaf(root.left, leave)
            getLeaf(root.right, leave)
        }
    }
}
