package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words
class LongestPalindromeByConcatenatingTwoLetterWords {
    fun longestPalindrome(words: Array<String>): Int {
        val count = mutableMapOf<String, Int>()
        var result = 0
        var hasCenter = false

        for (word in words) {
            val reversed = word.reversed()
            if (count.getOrDefault(reversed, 0) > 0) {
                result += 4
                count[reversed] = count[reversed]!! - 1
            } else {
                count[word] = count.getOrDefault(word, 0) + 1
            }
        }

        for ((word, c) in count) {
            if (word[0] == word[1] && c > 0) {
                hasCenter = true
                break
            }
        }

        return result + if (hasCenter) 2 else 0
    }
}
