package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended
class MaximumNumberOfEventsThatCanBeAttended {
    fun maxEvents(events: Array<IntArray>): Int {
        val pq = PriorityQueue<Int>()
        events.sortBy { it[0] }
        var ans = 0
        var j = 0
        val maxDay = events.maxOf { it[1] }

        for (day in 1..maxDay) {
            // Add events starting today
            while (j < events.size && events[j][0] == day) {
                pq.offer(events[j][1])
                j++
            }

            // Remove expired events
            while (pq.isNotEmpty() && pq.peek() < day) {
                pq.poll()
            }

            // Attend an event
            if (pq.isNotEmpty()) {
                pq.poll()
                ans++
            }
        }

        return ans
    }
}
