package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-ideal-arrays
class CountNumberOfIdealArrays {

    companion object {
        const val MOD = 1_000_000_007
        const val MAX_N = 10010
        const val MAX_P = 15

        val c = Array(MAX_N + MAX_P) { IntArray(MAX_P + 1) }
        val sieve = IntArray(MAX_N)
        val ps = Array(MAX_N) { mutableListOf<Int>() }

        init {
            // Sieve for smallest prime factor
            for (i in 2 until MAX_N) {
                if (sieve[i] == 0) {
                    for (j in i until MAX_N step i) {
                        if (sieve[j] == 0) sieve[j] = i
                    }
                }
            }

            // Prime power counts
            for (i in 2 until MAX_N) {
                var x = i
                while (x > 1) {
                    val p = sieve[x]
                    var count = 0
                    while (x % p == 0) {
                        x /= p
                        count++
                    }
                    ps[i].add(count)
                }
            }

            // Binomial coefficients
            c[0][0] = 1
            for (i in 1 until MAX_N + MAX_P) {
                c[i][0] = 1
                for (j in 1..minOf(i, MAX_P)) {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD
                }
            }
        }
    }

    fun idealArrays(n: Int, maxValue: Int): Int {
        var ans = 0L
        for (x in 1..maxValue) {
            var mul = 1L
            for (p in ps[x]) {
                mul = (mul * c[n + p - 1][p]) % MOD
            }
            ans = (ans + mul) % MOD
        }
        return ans.toInt()
    }
}
