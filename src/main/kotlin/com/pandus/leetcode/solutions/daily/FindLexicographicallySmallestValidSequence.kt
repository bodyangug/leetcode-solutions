package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence
class FindLexicographicallySmallestValidSequence {
    fun validSequence(word1: String, word2: String): IntArray? {
        val word1L = word1.length
        val word2L = word2.length

        val word1Char = word1.toCharArray()
        val word2Char = word2.toCharArray()

        val suf = IntArray(word1L + 1)
        var i = word1L - 1
        var j = word2L - 1
        while (i >= 0) {
            val el1 = word1Char[i]
            if (j >= 0 && el1 == word2Char[j]) {
                j--
            }
            suf[i] = word2L - 1 - j
            i--
        }

        var pointer1 = 0
        var pointer2 = 0
        val res = IntArray(word2L)
        var used = false
        while (pointer1 < word1L && pointer2 < word2L) {
            val el1 = word1Char[pointer1]
            val el2 = word2Char[pointer2]

            if (el1 == el2) {
                res[pointer2] = pointer1
                pointer2++
            } else if (!used && suf[pointer1 + 1] >= word2L - pointer2 - 1) {
                res[pointer2] = pointer1
                pointer2++
                used = true
            }
            pointer1++
        }

        if (pointer2 == word2L) {
            return res
        }
        return IntArray(0)
    }
}
