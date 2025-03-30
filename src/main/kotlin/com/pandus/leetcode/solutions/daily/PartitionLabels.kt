package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/partition-labels
class PartitionLabels {
    fun partitionLabels(s: String): MutableList<Int?> {
        // Stores the last index of each character in 's'
        val lastOccurrence = IntArray(26)
        for (i in 0..<s.length) {
            lastOccurrence[s[i].code - 'a'.code] = i
        }

        var partitionEnd = 0
        var partitionStart = 0
        val partitionSizes: MutableList<Int?> = ArrayList<Int?>()
        for (i in 0..<s.length) {
            partitionEnd = max(
                partitionEnd.toDouble(),
                lastOccurrence[s[i].code - 'a'.code].toDouble()
            ).toInt()
            // End of the current partition
            if (i == partitionEnd) {
                partitionSizes.add(i - partitionStart + 1)
                partitionStart = i + 1
            }
        }
        return partitionSizes
    }
}
