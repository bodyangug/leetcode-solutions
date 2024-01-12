package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/determine-if-string-halves-are-alike
class DetermineIfStringHalvesAreAlike {
    fun halvesAreAlike(s: String): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val half = s.length / 2
        var vowelCount = 0

        for (i in 0 until half) {
            if (s[i] in vowels) vowelCount++
            if (s[i + half] in vowels) vowelCount--
        }

        return vowelCount == 0
    }

}