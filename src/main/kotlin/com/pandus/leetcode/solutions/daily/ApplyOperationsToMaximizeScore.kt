package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/apply-operations-to-maximize-score
class ApplyOperationsToMaximizeScore {
    fun maximumScore(nums: List<Int>, k: Int): Int {
        val MOD = 1_000_000_007L
        val n = nums.size

        // 1) Precompute "scores" = number of distinct prime factors for each nums[i].
        //    (If numbers can be very large, consider an optimized factorization approach.)
        val scores = nums.map { countDistinctPrimeFactors(it) }

        // 2) For each index i, find the nearest bigger 'score' on the left and on the right.
        //    left[i] = index of next bigger score to the left, or -1 if none.
        //    right[i] = index of next bigger score to the right, or n if none.
        val left = IntArray(n) { -1 }
        val right = IntArray(n) { n }

        // We'll reuse two ArrayDeques as "monotonic stacks" from left and right.
        val stackL = ArrayDeque<Int>()
        val stackR = ArrayDeque<Int>()

        // 2a) Build left[] using a strictly monotonic decreasing stack (based on scores).
        for (i in 0 until n) {
            while (stackL.isNotEmpty() && scores[stackL.last()] < scores[i]) {
                stackL.removeLast()
            }
            if (stackL.isNotEmpty()) {
                left[i] = stackL.last()
            }
            stackL.addLast(i)
        }

        // 2b) Build right[] from the right side
        for (i in (n - 1) downTo 0) {
            while (stackR.isNotEmpty() && scores[stackR.last()] <= scores[i]) {
                stackR.removeLast()
            }
            if (stackR.isNotEmpty()) {
                right[i] = stackR.last()
            }
            stackR.addLast(i)
        }

        // 3) Sort indices by descending value in nums
        val sortedIndices = nums.indices.sortedByDescending { nums[it] }

        // 4) Repeatedly multiply the largest numbers, “weighted” by how many
        //    subranges they can be the "dominant" element (based on 'left' and 'right').
        var answer = 1L
        var remaining = k.toLong()

        for (i in sortedIndices) {
            if (remaining <= 0) break

            // Number of subranges in which nums[i] is the "max allowed by scores"
            // i.e. i can extend left until left[i]+1, and right until right[i]-1
            val countRanges = (i - left[i]).toLong() * (right[i] - i).toLong()
            val use = minOf(countRanges, remaining)

            if (use > 0) {
                // Fast exponentiation: multiply 'answer' by (nums[i]^use) % MOD
                answer = (answer * modPow(nums[i].toLong(), use, MOD)) % MOD
                remaining -= use
            }
        }

        return answer.toInt()
    }

    /**
     * Returns the count of distinct prime factors of [x].
     * If x can be large and you do this for many numbers,
     * consider a sieve-based approach for better performance.
     */
    private fun countDistinctPrimeFactors(x: Int): Int {
        var tmp = x
        var count = 0
        var p = 2
        while (p.toLong() * p <= tmp.toLong()) {
            if (tmp % p == 0) {
                count++
                while (tmp % p == 0) tmp /= p
            }
            p++
        }
        // If what's left is > 1, it's a prime factor itself
        if (tmp > 1) count++
        return count
    }

    /**
     * Binary exponentiation: computes (base^exp) % mod efficiently.
     */
    private fun modPow(base: Long, exp: Long, mod: Long): Long {
        var result = 1L
        var cur = base % mod
        var e = exp
        while (e > 0) {
            if ((e and 1L) == 1L) {
                result = (result * cur) % mod
            }
            cur = (cur * cur) % mod
            e = e shr 1
        }
        return result
    }
}
