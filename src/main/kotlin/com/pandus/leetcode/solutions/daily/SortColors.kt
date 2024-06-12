package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/sort-colors
class SortColors {
    fun sortColors(nums: IntArray) {
        var p0 = 0
        var curr = 0

        var p2 = nums.size - 1

        var tmp: Int
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0]
                nums[p0++] = nums[curr]
                nums[curr++] = tmp
            } else if (nums[curr] == 2) {
                tmp = nums[curr]
                nums[curr] = nums[p2]
                nums[p2--] = tmp
            } else curr++
        }
    }
}