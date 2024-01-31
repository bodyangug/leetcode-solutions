package com.pandus.leetcode.solutions.daily

import java.util.Stack


//Reference: https://leetcode.com/problems/evaluate-reverse-polish-notation
class EvaluateReversePolishNotation {

    private val OPERATIONS: Map<String, (Int, Int) -> Int> = mapOf(
        "+" to { a, b -> a + b },
        "-" to { a, b -> a - b },
        "*" to { a, b -> a * b },
        "/" to { a, b -> a / b }
    )

    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()

        for (token in tokens) {
            if (token in OPERATIONS) {
                val number2 = stack.pop()
                val number1 = stack.pop()
                stack.push(OPERATIONS[token]!!.invoke(number1, number2))
            } else {
                stack.push(token.toInt())
            }
        }

        return stack.pop()
    }
}
