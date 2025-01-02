package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-vowel-strings-in-ranges
class CountVowelStringsInRanges {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val ans = IntArray(queries.size)
        val vowels = HashSet(
            mutableListOf('a', 'e', 'i', 'o', 'u')
        )
        val prefixSum = IntArray(words.size)
        var sum = 0
        for (i in words.indices) {
            val currentWord = words[i]
            if (vowels.contains(currentWord[0]) &&
                vowels.contains(currentWord[currentWord.length - 1])
            ) {
                sum++
            }
            prefixSum[i] = sum
        }

        for (i in queries.indices) {
            val currentQuery = queries[i]
            ans[i] =
                prefixSum[currentQuery[1]] -
                        (if (currentQuery[0] == 0) 0 else prefixSum[currentQuery[0] - 1])
        }
        return ans
    }
}
