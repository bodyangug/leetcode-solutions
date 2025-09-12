package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/vowels-game-in-a-string
class VowelsGameInString {
    fun doesAliceWin(s: String): Boolean {
        for (char in s) {
            if (char in "aeiouAEIOU") {
                return true
            }
        }
        return false
    }
}
