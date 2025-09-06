package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero
class MinimumOperationsToMakeArrayElementsZero {
    private fun prefixCount(num: Int): Long {
        if (num <= 0) return 0L

        var total = 0L
        var blockStart = 1L
        var k = 0

        while (blockStart <= num.toLong()) {
            val blockEnd = minOf(blockStart * 2 - 1, num.toLong())
            val length = blockEnd - blockStart + 1
            val weight = (k / 2) + 1

            total += length * weight
            blockStart = blockStart shl 1
            k++
        }
        return total
    }

    fun minOperations(queries: Array<IntArray>): Long {
        var acc = 0L
        for (q in queries) {
            val l = q[0]
            val r = q[1]
            val upToR = prefixCount(r)
            val upToLMinus1 = prefixCount(l - 1)
            acc += (upToR - upToLMinus1 + 1) / 2
        }
        return acc
    }
}
