package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/adding-spaces-to-a-string
class AddingSpacesToString {
    fun addSpaces(s: String, spaces: IntArray): String {
        val result = StringBuilder()
        var spaceIndex = 0
        for (stringIndex in s.indices) {
            if (spaceIndex < spaces.size && stringIndex == spaces[spaceIndex]
            ) {
                result.append(' ')
                spaceIndex++
            }
            result.append(s[stringIndex])
        }
        return result.toString()
    }
}
