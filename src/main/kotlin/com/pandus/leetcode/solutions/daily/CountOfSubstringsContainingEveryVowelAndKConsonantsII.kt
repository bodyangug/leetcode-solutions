package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii
class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    fun countOfSubstrings(w: String, k: Int): Long {
        fun atLeast(k: Int): Long {
            var r = 0L
            var j = 0
            val cnt = IntArray(6)
            var u = 0
            for (i in w.indices) {
                val p = "aeiou".indexOf(w[i]) + 1
                if (cnt[p]++ < 1 && p > 0) u++
                while (u == 5 && cnt[0] >= k) {
                    r += w.length - i
                    val p = "aeiou".indexOf(w[j++]) + 1
                    if (--cnt[p] < 1 && p > 0) u--
                }
            }
            return r
        }
        return atLeast(k) - atLeast(k + 1)
    }
}