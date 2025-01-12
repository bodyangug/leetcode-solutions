package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid
class CheckIfParenthesesStringCanBeValid {
    fun canBeValid(s: String, locked: String, o: Char = '('): Boolean {
        if (s.length % 2 > 0) return false
        var b = 0
        for (i in s.indices)
            if (s[i] == o || locked[i] == '0') b++
            else if (--b < 0) return false
        return o == ')' || canBeValid(s.reversed(), locked.reversed(), ')')
    }
}
