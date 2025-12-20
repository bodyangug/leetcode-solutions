package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/delete-columns-to-make-sorted
class DeleteColumnsToMakeSorted {
    fun minDeletionSize(strs: Array<String>): Int {
        var deleteCount = 0
        val n = strs.size
        val m = strs[0].length

        for (col in 0 until m) {
            for (row in 1 until n) {
                if (strs[row][col] < strs[row - 1][col]) {
                    deleteCount++
                    break
                }
            }
        }

        return deleteCount
    }
}
