package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-resultant-array-after-removing-anagrams
class FindResultantArrayAfterRemovingAnagrams {
    fun removeAnagrams(words: Array<String>): List<String> {
        return words.fold(mutableListOf()) { acc, word ->
            if (acc.isEmpty() || acc.last().toCharArray().sorted() != word.toCharArray().sorted()) {
                acc.add(word)
            }
            acc
        }
    }
}
