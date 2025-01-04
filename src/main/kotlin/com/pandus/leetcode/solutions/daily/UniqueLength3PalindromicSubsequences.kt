package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/unique-length-3-palindromic-subsequences
class UniqueLength3PalindromicSubsequences {
    fun countPalindromicSubsequence(s: String): Int {
        val uniqueLetters = s.toSet() // Collect unique characters in the string
        var count = 0

        for (letter in uniqueLetters) {
            val firstIndex = s.indexOf(letter)
            val lastIndex = s.lastIndexOf(letter)

            // If the character appears more than once
            if (firstIndex != lastIndex) {
                // Collect all unique characters between the first and last occurrence
                val betweenChars = s.substring(firstIndex + 1, lastIndex).toSet()
                count += betweenChars.size
            }
        }
        return count
    }
}
