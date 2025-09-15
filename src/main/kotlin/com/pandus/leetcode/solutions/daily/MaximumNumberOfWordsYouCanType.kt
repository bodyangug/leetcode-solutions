package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-number-of-words-you-can-type
class MaximumNumberOfWordsYouCanType {
    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val brokenSet = brokenLetters.toSet()
        return text.split(" ").count { word ->
            word.all { char -> char !in brokenSet }
        }
    }
}
