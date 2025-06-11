package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii
class MaximumDifferenceBetweenEvenAndOddFrequencyII {
    fun maxDifference(s: String, k: Int): Int {
        val n = s.length
        var maxDiff = Int.MIN_VALUE

        for (a in '0'..'4') {
            for (b in '0'..'4') {
                if (a == b) continue

                val best = IntArray(4) { Int.MAX_VALUE }
                var countA = 0
                var countB = 0
                var prevA = 0
                var prevB = 0
                var left = -1

                for (right in 0 until n) {
                    if (s[right] == a) countA++
                    if (s[right] == b) countB++

                    while (right - left >= k && countB - prevB >= 2) {
                        val status = ((prevA and 1) shl 1) or (prevB and 1)
                        best[status] = minOf(best[status], prevA - prevB)

                        left++
                        if (s[left] == a) prevA++
                        if (s[left] == b) prevB++
                    }

                    val status = ((countA and 1) shl 1) or (countB and 1)
                    val requiredStatus = status xor 2

                    if (best[requiredStatus] != Int.MAX_VALUE) {
                        val diff = (countA - countB) - best[requiredStatus]
                        maxDiff = maxOf(maxDiff, diff)
                    }
                }
            }
        }
        return maxDiff
    }
}
