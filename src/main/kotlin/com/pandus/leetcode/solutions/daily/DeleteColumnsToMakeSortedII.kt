package com.pandus.leetcode.solutions.daily

// Reference: http://leetcode.com/problems/delete-columns-to-make-sorted-ii
class DeleteColumnsToMakeSortedII {
    fun minDeletionSize(strs: Array<String>): Int {
        var deleteCount = 0
        val n = strs.size
        val m = strs[0].length
        val sorted = BooleanArray(n - 1) { false }
        for (col in 0 until m) {
            var needToDelete = false

            for (row in 1 until n) {
                if (!sorted[row - 1] && strs[row][col] < strs[row - 1][col]) {
                    needToDelete = true
                    break
                }
            }

            if (needToDelete) {
                deleteCount++
            } else {
                for (row in 1 until n) {
                    if (strs[row][col] > strs[row - 1][col]) {
                        sorted[row - 1] = true
                    }
                }
            }
        }
        return deleteCount
    }
}
