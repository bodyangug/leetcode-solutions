package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/maximize-the-number-of-partitions-after-operations
class MaximizeNumberOfPartitionsAfterOperations {

    private data class PartitionState(
        val partitions: Int,
        val charMask: Int,
        val distinctCount: Int
    )

    fun maxPartitionsAfterOperations(s: String, k: Int): Int {
        val n = s.length
        val left = Array(n) { PartitionState(0, 0, 0) }
        val right = Array(n) { PartitionState(0, 0, 0) }

        // Build left partition states
        var state = PartitionState(0, 0, 0)
        for (i in 0 until n - 1) {
            state = updateState(state, s[i], k)
            left[i + 1] = state
        }

        // Build right partition states
        state = PartitionState(0, 0, 0)
        for (i in n - 1 downTo 1) {
            state = updateState(state, s[i], k)
            right[i - 1] = state
        }

        // Find maximum partitions
        var maxPartitions = 0
        for (i in 0 until n) {
            var segments = left[i].partitions + right[i].partitions + 2
            val combinedMask = left[i].charMask or right[i].charMask
            val combinedDistinct = Integer.bitCount(combinedMask)

            if (left[i].distinctCount == k && right[i].distinctCount == k && combinedDistinct < 26) {
                segments++
            } else if (min(combinedDistinct + 1, 26) <= k) {
                segments--
            }
            maxPartitions = max(maxPartitions, segments)
        }
        return maxPartitions
    }

    private fun updateState(state: PartitionState, char: Char, k: Int): PartitionState {
        val charBit = 1 shl (char.code - 'a'.code)

        return if ((state.charMask and charBit) == 0) {
            val newCount = state.distinctCount + 1
            if (newCount <= k) {
                PartitionState(
                    partitions = state.partitions,
                    charMask = state.charMask or charBit,
                    distinctCount = newCount
                )
            } else {
                PartitionState(
                    partitions = state.partitions + 1,
                    charMask = charBit,
                    distinctCount = 1
                )
            }
        } else {
            state
        }
    }
}
