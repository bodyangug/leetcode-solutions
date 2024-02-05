package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/first-unique-character-in-a-string
class FirstUniqueCharacterInString {
    fun firstUniqChar(s: String): Int {
        val count = s.groupingBy { it }.eachCount()
        return s.indices.firstOrNull { count[s[it]] == 1 } ?: -1
    }
}

