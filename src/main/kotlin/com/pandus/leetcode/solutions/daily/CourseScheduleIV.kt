package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/course-schedule-iv
class CourseScheduleIV {
    fun checkIfPrerequisite(n: Int, pre: Array<IntArray>, q: Array<IntArray>): List<Boolean> {
        val g = pre.groupBy { it[1] }
        val dp = HashMap<Int, Set<Int>>()
        fun dfs(i: Int): Set<Int> = dp.getOrPut(i) {
            ((g[i]?.map { dfs(it[0]) }?.flatten() ?: setOf()) + i).toSet()
        }
        return q.map { (a, b) -> a in dfs(b) }
    }
}
