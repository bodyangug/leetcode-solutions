package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.TreeNode

//Reference: https://leetcode.com/problems/same-tree
class SameTree {

//    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
//        if (p == null && q == null) return true
//        if (p == null || q == null) return false
//        if (p.`val` != q.`val`) return false
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
//    }

    private var ans = true

    fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
        return eq(p, q)
    }

    private fun eq(left: TreeNode?, right: TreeNode?): Boolean {
        if (left != null && right != null) {
            val leftVal = left.`val`
            val rightVal = right.`val`

            if (leftVal == rightVal) {
                val left1 = left.left
                val left2 = right.left
                eq(left1, left2)

                val right1 = left.right
                val right2 = right.right
                eq(right1, right2)
            } else {
                ans = false
            }
        } else if ((left != null && right == null) || (right != null && left == null)) {
            ans = false
        }
        return ans
    }


}