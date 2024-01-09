package com.pandus.leetcode.solutions.top.interview

//Reference: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
class RemoveDuplicatesFromSortedArray2 {
    fun removeDuplicates1(nums: IntArray): Int {
        var right = 1
        var count = 1
        var size = nums.size
        while (right < size) {
            if (nums[right] == nums[right - 1]) {
                count++;
                if (count > 2) {
                    removeEl(nums, right)
                    size--
                    right--
                }
            } else {
                count = 1
            }
            right++
        }
        return size
    }

    private fun removeEl(arr: IntArray, index: Int): IntArray {
        for (i in index + 1..<arr.size) {
            arr[i - 1] = arr[i]
        }
        return arr
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) {
            return nums.size
        }

        var left = 2
        for (right in 2..<nums.size) {
            if (nums[right] != nums[left - 2]) {
                nums[left] = nums[right]
                left++
            }
        }
        return left
    }
}