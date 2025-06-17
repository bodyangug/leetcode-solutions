package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements
class CountNumberOfArraysWithKMatchingAdjacentElements {
    private val mod = 1_000_000_007
    private val mx = 100_000

    private val fact: LongArray by lazy {
        LongArray(mx).also { f ->
            f[0] = 1L
            for (i in 1 until mx) {
                f[i] = f[i - 1] * i % mod
            }
        }
    }

    private val invFact: LongArray by lazy {
        LongArray(mx).also { inv ->
            inv[mx - 1] = qpow(fact[mx - 1], mod - 2)
            for (i in mx - 2 downTo 0) {
                inv[i] = inv[i + 1] * (i + 1) % mod
            }
        }
    }

    private fun qpow(x: Long, n: Int): Long {
        var result = 1L
        var base = x % mod
        var exponent = n
        while (exponent > 0) {
            if (exponent and 1 == 1) {
                result = result * base % mod
            }
            base = base * base % mod
            exponent = exponent shr 1
        }
        return result
    }

    private fun comb(n: Int, m: Int): Long {
        if (m < 0 || m > n) return 0L
        return fact[n] * invFact[m] % mod * invFact[n - m] % mod
    }

    fun countGoodArrays(n: Int, m: Int, k: Int): Int {
        val choose = comb(n - 1, k)
        val multiplier = qpow((m - 1).toLong(), n - k - 1)
        return ((choose * m % mod) * multiplier % mod).toInt()
    }
}
