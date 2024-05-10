package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/k-th-smallest-prime-fraction
class KthSmallestPrimeFraction {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val n = arr.size
        var left = 0.0
        var right = 1.0

        // Binary search for finding the kth smallest prime fraction
        while (left < right) {
            // Calculate the middle value
            val mid = (left + right) / 2

            // Initialize variables to keep track of maximum fraction and indices
            var maxFraction = 0.0
            var totalSmallerFractions = 0
            var numeratorIdx = 0
            var denominatorIdx = 0
            var j = 1

            // Iterate through the array to find fractions smaller than mid
            for (i in 0 until n - 1) {
                while (j < n && arr[i] >= mid * arr[j]) {
                    j++
                }

                // Count smaller fractions
                totalSmallerFractions += (n - j)

                // If we have exhausted the array, break
                if (j == n) break

                // Calculate the fraction
                val fraction = arr[i].toDouble() / arr[j]

                // Update maxFraction and indices if necessary
                if (fraction > maxFraction) {
                    numeratorIdx = i
                    denominatorIdx = j
                    maxFraction = fraction
                }
            }

            // Check if we have found the kth smallest prime fraction
            if (totalSmallerFractions == k) {
                return intArrayOf(arr[numeratorIdx], arr[denominatorIdx])
            } else if (totalSmallerFractions > k) {
                right = mid // Adjust the range for binary search
            } else {
                left = mid // Adjust the range for binary search
            }
        }
        return intArrayOf() // Return empty array if kth smallest prime fraction not found
    }
}
