package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-special-characters-i
class CountNumberOfSpecialCharactersI {
    fun numberOfSpecialChars(word: String): Int {
        val lowerCaseSet = mutableSetOf<Char>()
        val upperCaseSet = mutableSetOf<Char>()
        for (c in word) {
            if (c.isLowerCase()) {
                lowerCaseSet.add(c)
            } else {
                upperCaseSet.add(c)
            }
        }
        var count = 0
        for (c in lowerCaseSet) {
            if (upperCaseSet.contains(c.uppercaseChar())) {
                count++
            }
        }
        return count
    }
}
