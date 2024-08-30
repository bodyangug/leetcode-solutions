package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/daily-temperatures
class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()

        for ((index, temperature) in temperatures.withIndex()) {
            while (stack.isNotEmpty() && temperatures[stack.last()] < temperature) {
                val day = stack.removeLast()
                result[day] = index - day
            }
            stack.add(index)
        }

        return result
    }
}
