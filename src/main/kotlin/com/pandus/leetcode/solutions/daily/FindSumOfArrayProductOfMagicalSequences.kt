package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-sum-of-array-product-of-magical-sequences
class FindSumOfArrayProductOfMagicalSequences {

    private companion object {
        const val MOD = 1000000007L
    }

    private fun modPow(base: Long, exp: Long): Long {
        var exponent = exp
        var result = 1L
        var current = base % MOD
        while (exponent > 0) {
            if (exponent and 1L == 1L) {
                result = (result * current) % MOD
            }
            exponent = exponent shr 1
            current = (current * current) % MOD
        }
        return result
    }

    private fun modInverse(x: Long) = modPow(x, MOD - 2)

    fun magicalSum(m: Int, k: Int, nums: IntArray): Int {
        val n = nums.size

        // Precompute factorials
        val factorial = LongArray(m + 1)
        factorial[0] = 1
        for (i in 1..m) {
            factorial[i] = (factorial[i - 1] * i) % MOD
        }

        // Precompute inverse factorials
        val invFactorial = LongArray(m + 1)
        invFactorial[m] = modInverse(factorial[m])
        for (i in m - 1 downTo 0) {
            invFactorial[i] = (invFactorial[i + 1] * (i + 1)) % MOD
        }

        // Precompute powers of each number
        val numsPower = Array(n) { i ->
            LongArray(m + 1).also { powers ->
                powers[0] = 1
                for (j in 1..m) {
                    powers[j] = (powers[j - 1] * nums[i]) % MOD
                }
            }
        }

        // Dynamic programming table
        val dp = Array(n) {
            Array(m + 1) {
                Array(m * 2 + 1) {
                    LongArray(k + 1)
                }
            }
        }

        // Initialize first element
        for (j in 0..m) {
            dp[0][j][j][0] = (numsPower[0][j] * invFactorial[j]) % MOD
        }

        // Fill DP table
        for (i in 0 until n - 1) {
            for (j in 0..m) {
                for (p in 0..m * 2) {
                    for (q in 0..k) {
                        if (dp[i][j][p][q] == 0L) continue

                        val newQ = (p % 2) + q
                        if (newQ > k) continue

                        for (r in 0..(m - j)) {
                            val newP = p / 2 + r
                            val contribution = (dp[i][j][p][q] * numsPower[i + 1][r] % MOD * invFactorial[r]) % MOD
                            dp[i + 1][j + r][newP][newQ] = (dp[i + 1][j + r][newP][newQ] + contribution) % MOD
                        }
                    }
                }
            }
        }

        // Collect results
        var result = 0L
        for (p in 0..m * 2) {
            for (q in 0..k) {
                if (Integer.bitCount(p) + q == k) {
                    result = (result + dp[n - 1][m][p][q] * factorial[m]) % MOD
                }
            }
        }
        return result.toInt()
    }
}
