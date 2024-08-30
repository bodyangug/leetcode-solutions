package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-score-words-formed-by-letters
class MaximumScoreWordsFormedByLetters {
    private var maxScore = 0
    private lateinit var freq: IntArray

    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        // Count how many times each letter occurs
        freq = IntArray(26)
        for (c in letters) {
            freq[c - 'a']++
        }
        maxScore = 0
        val memo = mutableMapOf<Pair<Int, IntArray>, Int>()
        check(words.size - 1, words, score, IntArray(26), 0, memo)
        return maxScore
    }

    private fun check(
        w: Int,
        words: Array<String>,
        score: IntArray,
        subsetLetters: IntArray,
        totalScore: Int,
        memo: MutableMap<Pair<Int, IntArray>, Int>
    ) {
        if (w == -1) {
            // If all words have been iterated, check the score of this subset
            maxScore = maxOf(maxScore, totalScore)
            return
        }

        val key = w to subsetLetters.copyOf()
        if (memo.containsKey(key)) {
            maxScore = maxOf(maxScore, memo[key]!!)
            return
        }

        // Not adding words[w] to the current subset
        check(w - 1, words, score, subsetLetters, totalScore, memo)

        // Adding words[w] to the current subset
        val l = words[w].length
        var valid = true
        var newScore = totalScore
        for (i in 0 until l) {
            val c = words[w][i] - 'a'
            subsetLetters[c]++
            newScore += score[c]
            if (subsetLetters[c] > freq[c]) {
                valid = false
            }
        }

        if (valid) {
            // Consider the next word if this subset is still valid
            check(w - 1, words, score, subsetLetters, newScore, memo)
        }

        // Rollback effects of this word
        for (i in 0 until l) {
            val c = words[w][i] - 'a'
            subsetLetters[c]--
        }

        memo[key] = maxScore
    }
}
