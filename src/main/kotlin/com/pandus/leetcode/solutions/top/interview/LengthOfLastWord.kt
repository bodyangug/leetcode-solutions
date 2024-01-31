package com.pandus.leetcode.solutions.top.interview

//Reference: https://leetcode.com/problems/length-of-last-word
class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        return  "\\w+".toRegex().findAll(s).map { it.value }.toList().last().length
    }
}
