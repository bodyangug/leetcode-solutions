package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-fair-pairs
class CountNumberOfFairPairs {
    private fun lowerBound(
        nums: IntArray,
        low: Int,
        high: Int,
        element: Int
    ): Long {
        var low = low
        var high = high
        while (low <= high) {
            val mid = low + ((high - low) / 2)
            if (nums[mid] >= element) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return low.toLong()
    }

    fun countFairPairs(
        nums: IntArray,
        lower: Int,
        upper: Int
    ): Long {
        nums.sort()
        var ans: Long = 0
        for (i in nums.indices) {
            // Assume we have picked nums[i] as the first pair element.
            // `low` indicates the number of possible pairs with sum < lower.
            val low = lowerBound(
                nums,
                i + 1,
                nums.size - 1,
                lower - nums[i]
            )
            // `high` indicates the number of possible pairs with sum <= upper.
            val high = lowerBound(
                nums,
                i + 1,
                nums.size - 1,
                upper - nums[i] + 1
            )
            // Their difference gives the number of elements with sum in the given range.
            ans += 1 * (high - low)
        }
        return ans
    }
}
