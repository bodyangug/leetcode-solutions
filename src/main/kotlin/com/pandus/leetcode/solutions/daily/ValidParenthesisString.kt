package com.pandus.leetcode.solutions.daily

import jdk.internal.org.jline.utils.Colors
import java.util.Stack


//Reference: https://leetcode.com/problems/valid-parenthesis-string
class ValidParenthesisString {
    fun checkValidString(s: String): Boolean {
        val openBrackets = Stack<Int>()
        val asterisks = Stack<Int>()

        for (i in s.indices) {
            val ch: Char = s[i]
            if (ch == '(') {
                openBrackets.push(i)
            } else if (ch == '*') {
                asterisks.push(i)
            } else {
                if (!openBrackets.empty()) {
                    openBrackets.pop()
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop()
                } else {
                    return false
                }
            }
        }
        while (!openBrackets.isEmpty() && !asterisks.isEmpty()) {
            if (openBrackets.pop() > asterisks.pop()) {
                return false
            }
        }
        return openBrackets.isEmpty()

    }
}
