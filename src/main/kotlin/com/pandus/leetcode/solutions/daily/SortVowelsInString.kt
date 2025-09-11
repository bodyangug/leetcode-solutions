package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sort-vowels-in-a-string
class SortVowelsInString {
    fun sortVowels(s: String): String {
        val vowels = "aeiouAEIOU"
        val vowelChars = s.filter { it in vowels }.toCharArray().sorted()
        val result = StringBuilder(s)
        var vowelIndex = 0
        for (i in s.indices) {
            if (s[i] in vowels) {
                result[i] = vowelChars[vowelIndex]
                vowelIndex++
            }
        }
        return result.toString()
    }
}
