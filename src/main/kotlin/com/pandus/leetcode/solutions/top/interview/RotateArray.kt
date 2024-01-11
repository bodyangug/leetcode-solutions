package com.pandus.leetcode.solutions.top.interview

//Reference: https://leetcode.com/problems/rotate-array
class RotateArray {
    fun rotate1(nums: IntArray, k: Int): Unit {
        nums.mapIndexed { index, i ->
            Pair((index + k) % nums.size, i)
        }.forEach {
            nums[it.first] = it.second
        }
    }

    fun rotate2(nums: IntArray, k: Int): Unit {
        val steps = k % nums.size
        nums.reverse()
        nums.reverse(0, steps)
        nums.reverse(steps, nums.size)
    }

    private fun IntArray.reverse(from: Int, to: Int) {
        var start = from
        var end = to - 1
        while (start < end) {
            val temp = this[start]
            this[start] = this[end]
            this[end] = temp
            start++
            end--
        }
    }
}
