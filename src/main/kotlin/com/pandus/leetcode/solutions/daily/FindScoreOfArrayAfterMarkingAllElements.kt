package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements
class FindScoreOfArrayAfterMarkingAllElements {
    fun findScore(nums: IntArray): Long {
        val n = nums.size
        var s = 0L
        var j = 0
        while (j < n) {
            var odd = 0L
            var even = 0L
            while (j + 1 < n && nums[j] > nums[j + 1]) {
                if ((j and 1) == 1) odd += nums[j]
                else even += nums[j]
                j++
            }
            s += (if ((j and 1) == 1) odd else even) + nums[j]
            j += 2
        }
        return s
    }
}
