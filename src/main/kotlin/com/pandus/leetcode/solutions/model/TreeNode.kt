package com.pandus.leetcode.solutions.model

class TreeNode(
    var `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
) {
    constructor(rootVal: Int) : this(rootVal, null, null) {
    }
}
