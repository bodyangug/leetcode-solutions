package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

// Reference: https://leetcode.com/problems/maximum-average-pass-ratio
class MaximumAveragePassRatio {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val scores = PriorityQueue<IntArray>(
            compareBy {
                it[0].toDouble() / it[1] - (it[0] + 1).toDouble() / (it[1] + 1)
            }
        )
        scores += classes
        for (s in 1..extraStudents)
            scores += scores.poll().also {
                it[0]++
                it[1]++
            }
        return scores.sumOf { it[0].toDouble() / it[1] } / classes.size
    }
}
