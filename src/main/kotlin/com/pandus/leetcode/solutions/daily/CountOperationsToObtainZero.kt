package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-operations-to-obtain-zero
class CountOperationsToObtainZero {
    fun countOperations(num1: Int, num2: Int): Int {
        var num1 = num1
        var num2 = num2
        var res = 0 // total number of subtraction operations
        while (num1 != 0 && num2 != 0) {
            // each step of the Euclidean algorithm
            res += num1 / num2
            num1 %= num2
            // swap two numbers
            val temp = num1
            num1 = num2
            num2 = temp
        }
        return res
    }
}
