package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-missing-observations
class FindMissingObservations {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val sum = rolls.sumOf { it }
        val remainingSum = mean * (n + rolls.size) - sum
        // Check if sum is valid or not.
        if (remainingSum > 6 * n || remainingSum < n) {
            return IntArray(0)
        }
        val distributeMean = remainingSum / n
        val mod = remainingSum % n
        val nElements = IntArray(n) { distributeMean }
        for (i in 0 until mod) {
            nElements[i]++
        }
        return nElements
    }
}
