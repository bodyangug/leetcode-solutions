package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-n-and-its-double-exist
class CheckIfNAndItsDoubleExist {
    fun checkIfExist(arr: IntArray): Boolean {
        for (i in arr.indices) {
            for (j in arr.indices) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true
                }
            }
        }
        return false
    }
}
