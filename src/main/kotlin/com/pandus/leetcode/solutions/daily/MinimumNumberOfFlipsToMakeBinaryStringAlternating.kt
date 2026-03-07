package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating
class MinimumNumberOfFlipsToMakeBinaryStringAlternating {
    fun minFlips(s: String): Int {
        val n = s.length
        val doubled = s + s

        // Two target patterns: "010101..." and "101010..."
        // diff0 = mismatches with pattern starting with '0'
        // diff1 = mismatches with pattern starting with '1'
        var diff0 = 0
        var diff1 = 0

        for (i in doubled.indices) {
            val expected0 = if (i % 2 == 0) '0' else '1'
            val expected1 = if (i % 2 == 0) '1' else '0'

            if (doubled[i] != expected0) diff0++
            if (doubled[i] != expected1) diff1++

            // Remove the leftmost element when window exceeds size n
            if (i >= n) {
                val leftIdx = i - n
                val leftExpected0 = if (leftIdx % 2 == 0) '0' else '1'
                val leftExpected1 = if (leftIdx % 2 == 0) '1' else '0'

                if (doubled[leftIdx] != leftExpected0) diff0--
                if (doubled[leftIdx] != leftExpected1) diff1--
            }
        }

        // We need to find minimum across all valid windows
        // Reset and do sliding window properly
        diff0 = 0
        diff1 = 0
        var result = n

        for (i in doubled.indices) {
            val expected0 = if (i % 2 == 0) '0' else '1'
            val expected1 = if (i % 2 == 0) '1' else '0'

            if (doubled[i] != expected0) diff0++
            if (doubled[i] != expected1) diff1++

            if (i >= n) {
                val leftIdx = i - n
                val leftExpected0 = if (leftIdx % 2 == 0) '0' else '1'
                val leftExpected1 = if (leftIdx % 2 == 0) '1' else '0'

                if (doubled[leftIdx] != leftExpected0) diff0--
                if (doubled[leftIdx] != leftExpected1) diff1--
            }

            // Once we have a full window of size n
            if (i >= n - 1) {
                result = minOf(result, diff0, diff1)
            }
        }
        return result
    }
}
