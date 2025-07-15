package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/valid-word
class ValidWord {
    fun isValid(word: String): Boolean {
        if (word.length < 3) return false

        var hasVowel = false
        var hasConsonant = false

        for (c in word) {
            when {
                c.isLetter() -> {
                    when (c.lowercaseChar()) {
                        'a', 'e', 'i', 'o', 'u' -> hasVowel = true
                        else -> hasConsonant = true
                    }
                }
                !c.isDigit() -> return false
            }

            if (hasVowel && hasConsonant) {
                // Early exit optimization
                continue // allow loop to check rest for invalid characters
            }
        }

        return hasVowel && hasConsonant
    }
}
