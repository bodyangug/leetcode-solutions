package com.pandus.leetcode.solutions.top.interview


//Reference: https://leetcode.com/problems/single-number
class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        val frequencyMap = HashMap<Int, Int>()
        nums.forEach { num ->
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        for ((num, count) in frequencyMap) {
            if (count == 1) {
                return num
            }
        }

        return -1
    }

}