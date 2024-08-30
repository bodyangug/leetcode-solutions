package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/sum-of-subarray-minimums
class SumOfSubarrayMinimums {
    fun sumSubarrayMins(arr: IntArray): Int {
        val modulo = 1_000_000_007
        val n = arr.size
        val stack = ArrayDeque<Int>() // stack to keep indexes
        var sum: Long = 0

        for (i in 0 until n) {
            while (stack.isNotEmpty() && arr[stack.last()] > arr[i]) {
                val j = stack.removeLast()
                val k = if (stack.isEmpty()) -1 else stack.last()
                sum += arr[j].toLong() * (i - j) * (j - k) % modulo
                sum %= modulo
            }
            stack.addLast(i)
        }

        while (stack.isNotEmpty()) {
            val j = stack.removeLast()
            val k = if (stack.isEmpty()) -1 else stack.last()
            sum += arr[j].toLong() * (n - j) * (j - k) % modulo
            sum %= modulo
        }

        return sum.toInt()
    }
}
