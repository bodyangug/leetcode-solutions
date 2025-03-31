package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/put-marbles-in-bags
class PutMarblesInBags {
    fun putMarbles(weights: IntArray, k: Int): Long {
        val n = weights.size
        // Create an array of adjacent pair sums
        val pairWeights = (0 until n - 1).map { i ->
            weights[i] + weights[i + 1]
        }.toIntArray()

        // Sort the pair sums in ascending order
        pairWeights.sort()

        // The difference is the sum of top (k-1) minus the sum of bottom (k-1)
        var answer = 0L
        repeat(k - 1) { i ->
            // pairWeights[n - 2 - i] is the i-th largest pair sum
            // pairWeights[i] is the i-th smallest pair sum
            answer += (pairWeights[n - 2 - i] - pairWeights[i]).toLong()
        }
        return answer
    }
}
