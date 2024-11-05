package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/circular-sentence
class CircularSentence {
    fun isCircularSentence(sentence: String): Boolean {
        for (i in sentence.indices) {
            if (sentence[i] == ' ' && sentence[i - 1] != sentence[i + 1]) return false
        }
        return sentence[0] == sentence[sentence.length - 1]
    }
}
