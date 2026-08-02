package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-palindromic-rearrangement-ii
class SmallestPalindromicRearrangementII {
    fun smallestPalindrome(s: String, k: Int): String {
        val counts = IntArray(26)
        for (ch in s) counts[ch - 'a']++

        var middle = ""
        val half = IntArray(26)
        for (i in 0 until 26) {
            if (counts[i] % 2 == 1) middle = ('a' + i).toString()
            half[i] = counts[i] / 2
        }

        val halfLength = s.length / 2
        if (k.toLong() > multinomial(half)) return ""

        var remainingK = k.toLong()
        val remaining = half.copyOf()
        val builder = StringBuilder()
        for (position in 0 until halfLength) {
            for (c in 0 until 26) {
                if (remaining[c] == 0) continue
                remaining[c]--
                val permutations = multinomial(remaining)
                if (remainingK <= permutations) {
                    builder.append('a' + c)
                    break
                }
                remainingK -= permutations
                remaining[c]++
            }
        }

        val firstHalf = builder.toString()
        return firstHalf + middle + firstHalf.reversed()
    }

    // Number of distinct permutations of a multiset, capped to avoid overflow.
    private fun multinomial(counts: IntArray): Long {
        var result = 1L
        var used = 0
        for (c in 0 until 26) {
            if (counts[c] == 0) continue
            used += counts[c]
            result *= combination(used, counts[c])
            if (result > CAP) return CAP
        }
        return result
    }

    private fun combination(n: Int, r: Int): Long {
        if (r < 0 || r > n) return 0
        val k = minOf(r, n - r)
        var result = 1L
        for (i in 1..k) {
            result = result * (n - k + i) / i
            if (result > CAP) return CAP
        }
        return result
    }

    private companion object {
        const val CAP = 2_500_000_000L
    }
}
