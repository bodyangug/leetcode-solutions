package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/range-product-queries-of-powers
class RangeProductQueriesOfPowers {

    private val MOD: Long = 1_000_000_007L

    fun productQueries(nInput: Int, queries: Array<IntArray>): IntArray {
        require(nInput >= 0) { "n must be non-negative" }
        val exps = ArrayList<Int>(32)
        var n = nInput
        var bit = 0
        while (n > 0) {
            if ((n and 1) == 1) exps.add(bit)
            n = n ushr 1
            bit++
        }

        if (exps.isEmpty()) {
            return IntArray(queries.size) { 0 }
        }

        val pref = LongArray(exps.size + 1)
        for (i in exps.indices) {
            pref[i + 1] = pref[i] + exps[i]
        }

        val ans = IntArray(queries.size)
        for (i in queries.indices) {
            val l = queries[i][0]
            val r = queries[i][1]
            val e = pref[r + 1] - pref[l]
            ans[i] = powMod2(e).toInt()
        }
        return ans
    }

    private fun powMod2(exp: Long): Long {
        var e = exp
        val base = 2L
        var res = 1L
        var b = base % MOD
        while (e > 0) {
            if ((e and 1L) == 1L) res = (res * b) % MOD
            b = (b * b) % MOD
            e = e shr 1
        }
        return res
    }
}
