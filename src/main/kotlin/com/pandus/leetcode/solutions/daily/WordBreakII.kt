package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/word-break-ii
class WordBreakII {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val wordSet: Set<String> = HashSet(wordDict)
        val results: MutableList<String> = ArrayList()
        backtrack(s, wordSet, StringBuilder(), results, 0)
        return results
    }

    private fun backtrack(
        s: String,
        wordSet: Set<String>,
        currentSentence: StringBuilder,
        results: MutableList<String>,
        startIndex: Int
    ) {
        // If we've reached the end of the string, add the current sentence to results
        if (startIndex == s.length) {
            results.add(currentSentence.toString().trim { it <= ' ' })
            return
        }

        // Iterate over possible end indices
        for (endIndex in startIndex + 1..s.length) {
            val word = s.substring(startIndex, endIndex)
            // If the word is in the set, proceed with backtracking
            if (wordSet.contains(word)) {
                val currentLength = currentSentence.length
                currentSentence.append(word).append(" ")
                // Recursively call backtrack with the new end index
                backtrack(s, wordSet, currentSentence, results, endIndex)
                // Reset currentSentence to its original length
                currentSentence.setLength(currentLength)
            }
        }
    }
}
