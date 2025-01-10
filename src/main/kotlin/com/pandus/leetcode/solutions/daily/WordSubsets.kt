package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/word-subsets
class WordSubsets {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val maxFreq = IntArray(26)
        for (word in words2) {
            val freq = IntArray(26)
            for (c in word) {
                freq[c - 'a']++
            }
            for (i in 0 until 26) {
                maxFreq[i] = max(maxFreq[i], freq[i])
            }
        }
        return words1.filter { word ->
            val freq = IntArray(26)
            for (c in word) {
                freq[c - 'a']++
            }
            maxFreq.indices.all { maxFreq[it] <= freq[it] }
        }
    }
}
