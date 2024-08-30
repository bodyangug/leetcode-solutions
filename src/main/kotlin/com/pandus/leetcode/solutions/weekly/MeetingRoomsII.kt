package com.pandus.leetcode.solutions.weekly

import java.util.Arrays
import java.util.PriorityQueue

// Reference: https://leetcode.com/problems/meeting-rooms-ii
class MeetingRoomsII {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        val allocator = PriorityQueue<Int>(
            intervals.size
        ) { a, b -> a - b }

        Arrays.sort(
            intervals
        ) { a, b -> a[0] - b[0] }
        allocator.add(intervals[0][1])
        for (i in 1 until intervals.size) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll()
            }
            allocator.add(intervals[i][1])
        }
        return allocator.size
    }
}
