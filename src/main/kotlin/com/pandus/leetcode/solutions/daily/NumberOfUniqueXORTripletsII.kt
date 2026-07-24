package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-unique-xor-triplets-ii
class NumberOfUniqueXORTripletsII {
    fun uniqueXorTriplets(nums: IntArray): Int {
        val distinct = nums.toHashSet().toIntArray()

        var maxVal = 0
        for (v in distinct) if (v > maxVal) maxVal = v
        var size = 1
        while (size <= maxVal) size = size shl 1

        // All pairwise XOR values (i <= j). Repetition allowed, so a xor a == 0 is included.
        val pairXor = BooleanArray(size)
        for (i in distinct.indices) {
            for (j in i until distinct.size) {
                pairXor[distinct[i] xor distinct[j]] = true
            }
        }

        // XOR each reachable pair value with each element to get all triplet values.
        val tripletXor = BooleanArray(size)
        for (p in 0 until size) {
            if (!pairXor[p]) continue
            for (v in distinct) {
                tripletXor[p xor v] = true
            }
        }
        return tripletXor.count { it }
    }
}
