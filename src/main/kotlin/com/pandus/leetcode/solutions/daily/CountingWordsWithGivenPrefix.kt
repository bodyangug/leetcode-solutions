package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/counting-words-with-a-given-prefix
class CountingWordsWithGivenPrefix {
    fun prefixCount(words: Array<String>, pref: String) = words.count { it.startsWith(pref) }
}
