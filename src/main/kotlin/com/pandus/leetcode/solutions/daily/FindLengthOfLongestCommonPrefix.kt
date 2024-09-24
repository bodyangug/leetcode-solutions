package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix
class FindLengthOfLongestCommonPrefix {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val arr1Prefixes = mutableSetOf<Int>()

        // Step 1: Build all possible prefixes from arr1
        for (val1 in arr1) {
            var prefix = val1
            while (prefix > 0) {
                arr1Prefixes.add(prefix)
                prefix /= 10
            }
        }

        // Step 2: Check each number in arr2 for the longest matching prefix
        var longestPrefix = 0
        for (val2 in arr2) {
            var currentVal = val2
            while (currentVal > 0 && !arr1Prefixes.contains(currentVal)) {
                currentVal /= 10
            }
            if (currentVal > 0) {
                longestPrefix = maxOf(longestPrefix, currentVal.toString().length)
            }
        }
        return longestPrefix
    }
}
