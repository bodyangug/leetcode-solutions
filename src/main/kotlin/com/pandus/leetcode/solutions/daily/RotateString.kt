package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/rotate-string
class RotateString {
    fun rotateString(s: String, goal: String) =
        s.length == goal.length && "$s$s".contains(goal)
}
