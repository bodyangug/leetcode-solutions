package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii
class ConcatenateNonZeroDigitsAndMultiplyBySumII {
    fun sumAndMultiply(s: String, queries: Array<IntArray>): IntArray {
        val mod = 1_000_000_007L
        val m = s.length

        // pow10[k] = 10^k, invPow10[k] = 10^(-k) mod
        val pow10 = LongArray(m + 1)
        val invPow10 = LongArray(m + 1)
        pow10[0] = 1L
        for (k in 1..m) pow10[k] = pow10[k - 1] * 10 % mod
        val inv10 = modPow(10L, mod - 2, mod)
        invPow10[0] = 1L
        for (k in 1..m) invPow10[k] = invPow10[k - 1] * inv10 % mod

        // Prefix arrays over s:
        // count[i] = number of non-zero digits in s[0 until i]
        // digitSum[i] = sum of digits in s[0 until i]
        // weighted[i] = sum over non-zero digits d at position p < i of d * 10^(-count[p+1])
        val count = IntArray(m + 1)
        val digitSum = LongArray(m + 1)
        val weighted = LongArray(m + 1)
        for (i in 0 until m) {
            val d = (s[i] - '0').toLong()
            if (d != 0L) {
                count[i + 1] = count[i] + 1
                weighted[i + 1] = (weighted[i] + d * invPow10[count[i + 1]]) % mod
            } else {
                count[i + 1] = count[i]
                weighted[i + 1] = weighted[i]
            }
            digitSum[i + 1] = digitSum[i] + d
        }

        val answer = IntArray(queries.size)
        for (i in queries.indices) {
            val (l, r) = queries[i]
            // x = concatenation of non-zero digits in s[l..r]; for a digit at p its
            // exponent is (#non-zero after it in range) = count[r+1] - count[p+1],
            // so x = 10^count[r+1] * (weighted[r+1] - weighted[l]).
            val diff = (weighted[r + 1] - weighted[l] + mod) % mod
            val xMod = pow10[count[r + 1]] * diff % mod
            val sum = (digitSum[r + 1] - digitSum[l]) % mod
            answer[i] = (xMod * sum % mod).toInt()
        }
        return answer
    }

    private fun modPow(base: Long, exp: Long, mod: Long): Long {
        var result = 1L
        var b = base % mod
        var e = exp
        while (e > 0) {
            if (e and 1L == 1L) result = result * b % mod
            b = b * b % mod
            e = e shr 1
        }
        return result
    }
}
