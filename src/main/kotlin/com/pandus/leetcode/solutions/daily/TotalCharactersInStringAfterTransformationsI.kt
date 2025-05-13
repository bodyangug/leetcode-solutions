package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/total-characters-in-string-after-transformations-i
class TotalCharactersInStringAfterTransformationsI {
    val MOD = 1_000_000_007

    fun lengthAfterTransformations(s: String, t: Int): Int {
        var cnt = IntArray(26)
        for (ch in s) {
            cnt[ch - 'a']++
        }
        repeat(t) {
            val nxt = IntArray(26)
            nxt[0] = cnt[25]
            nxt[1] = (cnt[25] + cnt[0]) % MOD
            for (i in 2..25) {
                nxt[i] = cnt[i - 1]
            }
            cnt = nxt
        }
        return cnt.fold(0) { acc, value -> (acc + value) % MOD }
    }
}
