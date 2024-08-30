package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/ipo
class IPO {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        var w = w
        val n = profits.size
        val projects = arrayOfNulls<Project>(n)
        for (i in 0 until n) {
            projects[i] = Project(capital[i], profits[i])
        }
        projects.sort()
        // PriorityQueue is a min heap, but we need a max heap, so we use
        // Collections.reverseOrder()
        val q = PriorityQueue(n, Collections.reverseOrder<Int>())
        var ptr = 0
        for (i in 0 until k) {
            while (ptr < n && projects[ptr]!!.capital <= w) {
                q.add(projects[ptr++]!!.profit)
            }
            if (q.isEmpty()) {
                break
            }
            w += q.poll()
        }
        return w
    }
}

class Project(var capital: Int, var profit: Int) : Comparable<Project?> {
    override operator fun compareTo(project: Project?): Int {
        return capital - project!!.capital
    }
}
