package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.max

// Reference: https://leetcode.com/problems/two-best-non-overlapping-events
class TwoBestNonOverlappingEvents {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.first.compareTo(o2.first) }
        Arrays.sort(
            events
        ) { a: IntArray, b: IntArray -> a[0] - b[0] }
        var maxVal = 0
        var maxSum = 0

        for (event in events) {
            while (!pq.isEmpty() && pq.peek().first < event[0]) {
                maxVal = maxVal.coerceAtLeast(pq.peek().second)
                pq.poll()
            }
            maxSum = max(maxSum, (maxVal + event[2]))
            pq.add(Pair(event[1], event[2]))
        }
        return maxSum
    }
}
