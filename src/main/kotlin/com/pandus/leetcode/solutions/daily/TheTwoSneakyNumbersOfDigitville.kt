package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville
class TheTwoSneakyNumbersOfDigitville {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val seen = HashSet<Int>(nums.size)
        val dupes = LinkedHashSet<Int>()
        for (x in nums) {
            if (!seen.add(x)) {
                dupes.add(x)
            }
        }
        return dupes.toIntArray()
    }
}
