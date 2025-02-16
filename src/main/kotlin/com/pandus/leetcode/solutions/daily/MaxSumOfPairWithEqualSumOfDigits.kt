package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits
class MaxSumOfPairWithEqualSumOfDigits {
    fun maximumSum(nums: IntArray) = nums.groupBy { n -> "$n".sumOf { it - '0' } }
        .filter { it.value.size > 1 }
        .maxOfOrNull {
            it.value.sorted()
                .takeLast(2)
                .sum()
        } ?: -1
}
