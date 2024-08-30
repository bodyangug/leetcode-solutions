package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/task-scheduler
class TaskScheduler {

    fun leastInterval(tasks: CharArray, n: Int): Int {
        // freq array to store the frequency of each task
        val freq = IntArray(26)
        var maxCount = 0

        // Count the frequency of each task and find the maximum frequency
        for (task in tasks) {
            freq[task.code - 'A'.code]++
            maxCount = max(maxCount, freq[task.code - 'A'.code])
        }

        // Calculate the total time needed for execution
        var time = (maxCount - 1) * (n + 1)
        for (f in freq) {
            if (f == maxCount) {
                time++
            }
        }
        // Return the maximum of total time needed and the length of the task list
        return max(tasks.size, time)
    }
}
