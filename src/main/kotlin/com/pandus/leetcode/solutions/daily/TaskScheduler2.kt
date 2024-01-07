package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/task-scheduler-ii/description/
class TaskScheduler2 {
    fun taskSchedulerII(tasks: IntArray, space: Int): Long {
        val map = HashMap<Int, Long>()
        var res = 0L
        val diff = 1L + space
        tasks.indices.forEach {
            val lst = map.getOrDefault(tasks[it], -diff)
            if (res - lst < diff) {
                res = lst + diff
            } else {
                res++
            }
            map[tasks[it]] = res
        }
        return res
    }
}