package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sorted-gcd-pair-queries
class SortedGCDPairQueries {
    // You are given an integer array nums of length n and an integer array queries.
    //Let gcdPairs denote an array obtained by calculating the GCD of all possible pairs (nums[i], nums[j]), where 0 <= i < j < n, and then sorting these values in ascending order.
    //For each query queries[i], you need to find the element at index queries[i] in gcdPairs.
    //Return an integer array answer, where answer[i] is the value at gcdPairs[queries[i]] for each query.
    //The term gcd(a, b) denotes the greatest common divisor of a and b.
    fun gcdValues(nums: IntArray, queries: LongArray): IntArray {
        val maxVal = nums.maxOrNull() ?: 0

        // freq[v] = how many nums equal v
        val freq = IntArray(maxVal + 1)
        for (num in nums) freq[num]++

        // exactPairs[g] = number of pairs whose gcd is exactly g
        val exactPairs = LongArray(maxVal + 1)
        for (g in maxVal downTo 1) {
            var multiplesCount = 0L
            var overCount = 0L
            var m = g
            while (m <= maxVal) {
                multiplesCount += freq[m]
                overCount += exactPairs[m]
                m += g
            }
            // pairs with gcd divisible by g, minus pairs with gcd exactly 2g, 3g, ...
            exactPairs[g] = multiplesCount * (multiplesCount - 1) / 2 - overCount
        }

        // prefix[g] = number of pairs whose gcd is <= g (sorted gcdPairs is grouped by value)
        val prefix = LongArray(maxVal + 1)
        prefix[0] = 0
        for (g in 1..maxVal) {
            prefix[g] = prefix[g - 1] + exactPairs[g]
        }

        // For each query index, binary search the smallest gcd value whose prefix count exceeds it.
        return IntArray(queries.size) { i ->
            val target = queries[i]
            var lo = 1
            var hi = maxVal
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (prefix[mid] > target) hi = mid else lo = mid + 1
            }
            lo
        }
    }
}
