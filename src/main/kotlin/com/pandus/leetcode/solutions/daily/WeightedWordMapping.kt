package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/weighted-word-mapping
class WeightedWordMapping {
    fun mapWordWeights(words: Array<String>, weights: IntArray): String {
        val result = StringBuilder()
        for (word in words) {
            var weightSum = 0
            for (char in word) {
                weightSum += weights[char - 'a']
            }
            val mappedChar = 'z' - (weightSum % 26)
            result.append(mappedChar)
        }
        return result.toString()
    }
}
