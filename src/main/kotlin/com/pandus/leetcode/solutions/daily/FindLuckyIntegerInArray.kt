package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-lucky-integer-in-an-array
class FindLuckyIntegerInArray {
    fun findLucky(arr: IntArray): Int {
        val freqMap = mutableMapOf<Int, Int>()

        for (num in arr) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        var maxLucky = -1
        for ((num, count) in freqMap) {
            if (num == count) {
                maxLucky = maxOf(maxLucky, num)
            }
        }

        return maxLucky
    }
}
