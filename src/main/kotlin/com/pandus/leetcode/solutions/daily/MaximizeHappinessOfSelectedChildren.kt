package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue
import kotlin.math.max

// Reference: https://leetcode.com/problems/maximize-happiness-of-selected-children
class MaximizeHappinessOfSelectedChildren {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        val pq = PriorityQueue(Comparator.reverseOrder<Int>())

        for (h in happiness) {
            pq.add(h)
        }

        var totalHappinessSum: Long = 0

        for ((turns, _) in (0 until k).withIndex()) {
            totalHappinessSum += max((pq.poll() - turns), 0)
        }
        return totalHappinessSum
    }
}
