package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses
class MaximumNestingDepthOfParentheses {
    fun maxDepth(s: String): Int {
        var ans = 0
        var openBrackets = 0
        s.forEach {
            if (it == '(') {
                openBrackets++
            } else if (it == ')') {
                openBrackets--
            }
            ans = max(ans, openBrackets)
        }
        return ans
    }
}
