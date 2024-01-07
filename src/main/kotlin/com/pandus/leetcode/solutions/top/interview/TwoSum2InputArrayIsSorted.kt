package com.pandus.leetcode.solutions.top.interview

//Reference
class TwoSum2InputArrayIsSorted {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            when {
                sum < target -> left++
                sum > target -> right--
                else -> return intArrayOf(left + 1, right + 1)
            }
        }
        return intArrayOf(0, 0) // should never reach here if valid inputs
    }
}