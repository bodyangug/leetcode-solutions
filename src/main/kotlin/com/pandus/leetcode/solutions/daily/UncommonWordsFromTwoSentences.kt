package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/uncommon-words-from-two-sentences
class UncommonWordsFromTwoSentences {
    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        return (s1.split(" ") + s2.split(" "))
            .groupingBy { it }
            .eachCount()
            .filter { it.value < 2 }
            .keys
            .toTypedArray()
    }
}
