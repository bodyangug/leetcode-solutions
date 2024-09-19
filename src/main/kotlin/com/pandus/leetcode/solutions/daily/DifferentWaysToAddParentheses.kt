package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/different-ways-to-add-parentheses
class DifferentWaysToAddParentheses {
    fun diffWaysToCompute(expression: String): List<Int> {
        val results: MutableList<Int> = ArrayList()
        if (expression.isEmpty()) return results
        if (expression.length == 1) {
            results.add(expression.toInt())
            return results
        }
        if (expression.length == 2 && Character.isDigit(expression[0])) {
            results.add(expression.toInt())
            return results
        }

        // Recursive case: iterate through each character
        for (i in expression.indices) {
            val currentChar = expression[i]

            // Skip if the current character is a digit
            if (Character.isDigit(currentChar)) continue

            // Split the expression into left and right parts
            val leftResults = diffWaysToCompute(expression.substring(0, i))
            val rightResults = diffWaysToCompute(expression.substring(i + 1))

            // Combine results from left and right parts
            for (leftValue in leftResults) {
                for (rightValue in rightResults) {
                    var computedResult = 0

                    when (currentChar) {
                        '+' -> computedResult = leftValue + rightValue
                        '-' -> computedResult = leftValue - rightValue
                        '*' -> computedResult = leftValue * rightValue
                    }
                    results.add(computedResult)
                }
            }
        }
        return results
    }
}
