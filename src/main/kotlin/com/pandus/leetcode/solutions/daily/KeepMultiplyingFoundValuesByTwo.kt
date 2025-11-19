package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/keep-multiplying-found-values-by-two
class KeepMultiplyingFoundValuesByTwo {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        var res = original
        while (true) {
            val found = nums.contains(res)
            if (found) {
                res *= 2
            } else {
                break
            }
        }
        return res
    }
}
