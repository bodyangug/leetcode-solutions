package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks
class MinimumInitialEnergyToFinishTasks {
    fun minimumEffort(tasks: Array<IntArray>): Int {
        var ans = 0
        var sum = 0
        tasks.sortByDescending { it[1] - it[0] }
        for (task in tasks) {
            val actual = task[0]
            val minimum = task[1]
            if (sum < minimum) {
                ans += minimum - sum
                sum = minimum
            }
            sum -= actual
        }
        return ans
    }
}
