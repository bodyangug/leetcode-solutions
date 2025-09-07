package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero
class FindNUniqueIntegersSumUpToZero {
    fun sumZero(n: Int): IntArray {
        val ans = IntArray(n)
        var index = 0
        for (i in 1..n / 2) {
            ans[index++] = i
            ans[index++] = -i
        }
        if (n % 2 == 1) {
            ans[index] = 0
        }
        return ans
    }
}
