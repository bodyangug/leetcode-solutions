package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/delete-characters-to-make-fancy-string
class DeleteCharactersToMakeFancyString {
    fun makeFancyString(s: String): String = s
        .windowed(size = 3, step = 1, partialWindows = true)
        .joinToString("") {
            when {
                it.length < 3 || it[0] != it[1] || it[1] != it[2] -> it[0].toString()
                else -> ""
            }
        }
}
