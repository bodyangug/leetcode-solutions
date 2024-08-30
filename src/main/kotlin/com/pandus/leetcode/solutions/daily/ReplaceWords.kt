package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/replace-words
class ReplaceWords {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val dictSet = dictionary.toSet()
        val wordArray = sentence.split(" ").map { shortestRoot(it, dictSet) }
        return wordArray.joinToString(" ")
    }

    private fun shortestRoot(word: String, dictSet: Set<String>): String {
        for (i in 1..word.length) {
            val root = word.substring(0, i)
            if (dictSet.contains(root)) {
                return root
            }
        }
        return word
    }
}
