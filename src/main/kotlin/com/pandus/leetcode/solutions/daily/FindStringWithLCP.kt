package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-string-with-lcp
class FindStringWithLCP {
    fun findTheString(lcp: Array<IntArray>): String {
        val n = lcp.size

        // Step 1: Validate diagonal and symmetry
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (lcp[i][j] != lcp[j][i]) return ""
                if (lcp[i][j] < 0 || lcp[i][j] > n - maxOf(i, j)) return ""
            }
        }

        // Step 2: Greedily assign characters to build the lexicographically smallest string
        val word = CharArray(n) { '\u0000' }
        var currentChar = 'a'
        for (i in 0 until n) {
            if (word[i] != '\u0000') continue
            if (currentChar > 'z') return ""
            word[i] = currentChar
            for (j in i + 1 until n) {
                if (lcp[i][j] > 0 && word[j] == '\u0000') {
                    word[j] = currentChar
                }
            }
            currentChar++
        }

        // Step 3: Verify the constructed string by rebuilding the LCP matrix (bottom-up DP)
        val computed = Array(n) { IntArray(n) }
        for (i in n - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if (word[i] == word[j]) {
                    computed[i][j] = if (i + 1 < n && j + 1 < n) computed[i + 1][j + 1] + 1 else 1
                } else {
                    computed[i][j] = 0
                }
                if (computed[i][j] != lcp[i][j]) return ""
            }
        }
        return String(word)
    }
}
