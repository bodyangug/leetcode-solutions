package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-pivot-integer
class FindPivotInteger {
    fun pivotInteger(n: Int): Int {
        var sum = n * (n + 1) / 2
        var leftSum = 0

        for (i in 1 until n) {
            leftSum += i
            sum -= i

            if (leftSum == sum) {
                return i + 1
            }
        }
        return -1
    }
}
