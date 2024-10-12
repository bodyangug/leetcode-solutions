package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
class MinimumAddToMakeParenthesesValid {
    fun minAddToMakeValid(s: String): Int {
        var openBrackets = 0
        var minAddsRequired = 0
        for (c in s.toCharArray()) {
            if (c == '(') {
                openBrackets++
            } else {
                if (openBrackets > 0) {
                    openBrackets--
                } else {
                    minAddsRequired++
                }
            }
        }
        return minAddsRequired + openBrackets
    }
}
