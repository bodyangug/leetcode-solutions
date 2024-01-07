package com.pandus.leetcode.solutions.top.interview

//Reference: https://leetcode.com/problems/remove-element
class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var firstPointer = 0
        var secondPointer = 0

        while (firstPointer < nums.size) {
            if (nums[firstPointer] != `val`) {
                val temp = nums[firstPointer]
                nums[firstPointer] = nums[secondPointer]
                nums[secondPointer] = temp
                secondPointer++
            }
            firstPointer++
        }
        return nums.count { it != `val` }
    }
}