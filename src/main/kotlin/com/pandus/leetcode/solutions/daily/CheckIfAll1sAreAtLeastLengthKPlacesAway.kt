package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away
class CheckIfAll1sAreAtLeastLengthKPlacesAway {
    fun kLengthApart(nums: IntArray, k: Int): Boolean =
        nums.indices
            .filter { nums[it] == 1 }
            .zipWithNext { a, b -> b - a - 1 >= k }
            .all { it }
}
