package com.pandus.leetcode.solutions.daily

import java.util.Stack


//Reference: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses
class ReverseSubstringsBetweenEachPairParentheses {
    private val result = StringBuilder()

    fun reverseParentheses(s: String): String {
        val openParenthesesIndices = Stack<Int>()

        for (currentChar in s.toCharArray()) {
            when (currentChar) {
                '(' -> openParenthesesIndices.push(result.length)
                ')' -> {
                    val start = openParenthesesIndices.pop()
                    reverse(start, result.length - 1)
                }

                else -> result.append(currentChar)
            }
        }
        return result.toString()
    }

    private fun reverse(start: Int, end: Int) {
        var start = start
        var end = end
        while (start < end) {
            val temp = result[start]
            result.setCharAt(start++, result[end])
            result.setCharAt(end--, temp)
        }
    }
}