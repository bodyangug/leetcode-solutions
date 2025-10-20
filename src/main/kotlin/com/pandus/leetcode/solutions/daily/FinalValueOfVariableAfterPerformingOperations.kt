package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/final-value-of-variable-after-performing-operations
class FinalValueOfVariableAfterPerformingOperations {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var x = 0
        for (operation in operations) {
            when (operation) {
                "++X", "X++" -> x++
                "--X", "X--" -> x--
            }
        }
        return x
    }
}
