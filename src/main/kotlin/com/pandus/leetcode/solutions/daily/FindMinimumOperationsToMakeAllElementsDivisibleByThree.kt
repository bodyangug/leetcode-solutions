package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three
class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    fun minimumOperations(nums: IntArray): Int {
        var sum = 0
        for (x in nums) {
            val rem = x % 3
            sum += min(rem, 3 - rem)
        }
        return sum
    }
}
