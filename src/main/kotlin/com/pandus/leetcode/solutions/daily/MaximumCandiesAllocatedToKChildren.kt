package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/maximum-candies-allocated-to-k-children
class MaximumCandiesAllocatedToKChildren {
    fun maximumCandies(candies: IntArray, k: Long): Int {
        var maxCandiesInPile = 0
        for (i in candies.indices) {
            maxCandiesInPile = max(maxCandiesInPile, candies[i])
        }

        var left = 0
        var right = maxCandiesInPile

        while (left < right) {
            val middle = (left + right + 1) / 2

            if (canAllocateCandies(candies, k, middle)) {
                left = middle
            } else {
                right = middle - 1
            }
        }

        return left
    }

    private fun canAllocateCandies(
        candies: IntArray,
        k: Long,
        numOfCandies: Int
    ): Boolean {
        var maxNumOfChildren: Long = 0

        for (pileIndex in candies.indices) {
            maxNumOfChildren += (candies[pileIndex] / numOfCandies).toLong()
        }

        return maxNumOfChildren >= k
    }
}
