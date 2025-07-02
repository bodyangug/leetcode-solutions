package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-original-typed-string-ii
class FindOriginalTypedStringII {

    private val MOD = 1_000_000_007

    fun possibleStringCount(word: String, k: Int): Int {
        // Step 1: Run-length encode the string
        val freq = mutableListOf<Int>()
        var count = 1
        for (i in 1 until word.length) {
            if (word[i] == word[i - 1]) {
                count++
            } else {
                freq.add(count)
                count = 1
            }
        }
        freq.add(count)

        // Step 2: Multiply all run lengths modulo MOD
        var answer = 1L
        for (f in freq) {
            answer = (answer * f) % MOD
        }

        if (freq.size >= k) return answer.toInt()

        // Step 3: DP preparation
        var dp: IntArray
        var prefix = IntArray(k) { 1 }

        for (length in freq) {
            val nextDp = IntArray(k)
            for (j in 1 until k) {
                nextDp[j] = prefix[j - 1]
                if (j - length - 1 >= 0) {
                    nextDp[j] = (nextDp[j] - prefix[j - length - 1] + MOD) % MOD
                }
            }
            dp = nextDp
            prefix = IntArray(k).also { it[0] = dp[0] }
            for (j in 1 until k) {
                prefix[j] = (prefix[j - 1] + dp[j]) % MOD
            }
        }

        return ((answer - prefix[k - 1] + MOD) % MOD).toInt()
    }
}
