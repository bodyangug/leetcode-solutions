package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.ceil

// Reference: https://leetcode.com/problems/maximal-score-after-applying-k-operations
class MaximalScoreAfterApplyingKOperations {
    fun maxKelements(nums: IntArray, k: Int): Long {
        val queue = PriorityQueue<Int>(compareByDescending { it })
        nums.forEach { queue.add(it) }

        var maxVal: Int
        var score = 0L
        for (i in 0 until k) {
            maxVal = queue.poll()
            score += maxVal

            queue.add(ceil(maxVal / 3.0).toInt())
        }

        return score
    }
}
