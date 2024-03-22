package com.pandus.leetcode.solutions.weekly

//Reference: https://leetcode.com/problems/remove-vowels-from-a-string
class RemoveVowelsFromString {
    fun removeVowels(s: String): String {
        return s.filter { it !in setOf('a', 'e', 'i', 'o', 'u') }
    }
}
