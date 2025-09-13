package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-most-frequent-vowel-and-consonant
class FindMostFrequentVowelAndConsonant {
    fun maxFreqSum(s: String): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val vowelCount = IntArray(26)
        val consonantCount = IntArray(26)

        for (char in s) {
            if (char in vowels) {
                vowelCount[char - 'a']++
            } else if (char.isLetter()) {
                consonantCount[char - 'a']++
            }
        }

        val maxVowelFreq = vowelCount.maxOrNull() ?: 0
        val maxConsonantFreq = consonantCount.maxOrNull() ?: 0

        return maxVowelFreq + maxConsonantFreq
    }
}
