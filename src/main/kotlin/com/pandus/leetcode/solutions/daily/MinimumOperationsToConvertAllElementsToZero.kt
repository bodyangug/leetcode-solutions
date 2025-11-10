package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/
class MinimumOperationsToConvertAllElementsToZero {
    fun minOperations(nums: IntArray): Int {
        val s: MutableList<Int> = ArrayList()
        var res = 0
        for (a in nums) {
            while (!s.isEmpty() && s[s.size - 1] > a) {
                s.removeAt(s.size - 1)
            }
            if (a == 0) continue
            if (s.isEmpty() || s[s.size - 1] < a) {
                res++
                s.add(a)
            }
        }
        return res
    }
}
