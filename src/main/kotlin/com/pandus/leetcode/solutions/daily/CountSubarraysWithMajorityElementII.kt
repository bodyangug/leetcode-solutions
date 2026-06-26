package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-subarrays-with-majority-element-ii
class CountSubarraysWithMajorityElementII {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Long {
        val n = nums.size
        val size = 2 * n + 2 // prefix sums lie in [-n, n]; shift by n + 1 -> [1, 2n + 1]
        val bit = IntArray(size + 1)

        fun update(index: Int) {
            var i = index
            while (i <= size) {
                bit[i]++
                i += i and -i
            }
        }

        fun query(index: Int): Int {
            var sum = 0
            var i = index
            while (i > 0) {
                sum += bit[i]
                i -= i and -i
            }
            return sum
        }

        val offset = n + 1
        var prefix = 0
        var count = 0L

        update(prefix + offset) // prefix sum 0 at index 0
        for (num in nums) {
            prefix += if (num == target) 1 else -1
            val shifted = prefix + offset
            // number of earlier prefix sums strictly less than current
            count += query(shifted - 1)
            update(shifted)
        }
        return count
    }
}
