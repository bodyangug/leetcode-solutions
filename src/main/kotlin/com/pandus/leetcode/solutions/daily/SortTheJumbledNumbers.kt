package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/sort-the-jumbled-numbers
class SortTheJumbledNumbers {
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        val storePairs = nums.mapIndexed { index, num ->
            var mappedValue = 0
            var temp = num
            var place = 1

            if (temp != 0) {
                while (temp != 0) {
                    mappedValue += place * mapping[temp % 10]
                    place *= 10
                    temp /= 10
                }
            } else {
                mappedValue = mapping[0]
            }
            mappedValue to index
        }.sortedBy { it.first }

        return IntArray(nums.size) { i -> nums[storePairs[i].second] }
    }
}
