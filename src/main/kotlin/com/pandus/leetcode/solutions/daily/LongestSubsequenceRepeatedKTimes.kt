package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/longest-subsequence-repeated-k-times
class LongestSubsequenceRepeatedKTimes {
    fun longestSubsequenceRepeatedK(s: String, k: Int): String {
        val freq = IntArray(26)
        for (ch in s) freq[ch - 'a']++

        val candidate = mutableListOf<Char>()
        for (i in 25 downTo 0) {
            if (freq[i] >= k) {
                candidate.add(('a' + i))
            }
        }

        val queue: ArrayDeque<String> = ArrayDeque()
        candidate.forEach { queue.add(it.toString()) }

        var ans = ""
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            if (curr.length > ans.length || (curr.length == ans.length && curr > ans)) {
                ans = curr
            }

            if (curr.length == s.length / k) continue // pruning: can't be longer than max subseq length

            for (ch in candidate) {
                val next = curr + ch
                if (isKRepeatedSubsequence(s, next, k)) {
                    queue.add(next)
                }
            }
        }

        return ans
    }

    private fun isKRepeatedSubsequence(s: String, t: String, k: Int): Boolean {
        var pos = 0
        var matched = 0
        val m = t.length
        for (ch in s) {
            if (ch == t[pos]) {
                pos++
                if (pos == m) {
                    pos = 0
                    matched++
                    if (matched == k) return true
                }
            }
        }
        return false
    }
}
