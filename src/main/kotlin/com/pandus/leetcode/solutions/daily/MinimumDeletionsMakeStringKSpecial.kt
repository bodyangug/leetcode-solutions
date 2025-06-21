package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-deletions-to-make-string-k-special
class MinimumDeletionsMakeStringKSpecial {
    fun minimumDeletions(word: String, k: Int): Int {
        val freqMap = mutableMapOf<Char, Int>()
        for (ch in word) {
            freqMap[ch] = freqMap.getOrDefault(ch, 0) + 1
        }

        var result = word.length
        for (targetCount in freqMap.values) {
            var deletions = 0
            for (count in freqMap.values) {
                when {
                    count < targetCount -> deletions += 0
                    count > targetCount + k -> deletions += count - (targetCount + k)
                }
            }
            result = minOf(result, deletions)
        }

        return result
    }
}
