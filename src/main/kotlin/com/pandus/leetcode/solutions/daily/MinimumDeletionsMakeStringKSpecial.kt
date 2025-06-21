package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-deletions-to-make-string-k-special
class MinimumDeletionsMakeStringKSpecial {
    fun minimumDeletions(word: String, k: Int): Int {
        val freq = word.groupingBy { it }.eachCount().values.sorted()
        var result = word.length

        for (i in freq.indices) {
            val target = freq[i]
            var deletions = 0

            for (j in 0 until i) {
                deletions += freq[j]
            }

            for (j in i + 1 until freq.size) {
                if (freq[j] > target + k) {
                    deletions += freq[j] - (target + k)
                }
            }
            result = minOf(result, deletions)
        }

        return result
    }
}
