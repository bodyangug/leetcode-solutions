package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i
class FindMinimumTimeToReachLastRoomI {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val rows = moveTime.size
        val cols = moveTime[0].size
        val visited = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }
        val queue = PriorityQueue(compareBy<Pair<Int, Pair<Int, Int>>> { it.first })

        queue.add(0 to (0 to 0))
        visited[0][0] = 0

        val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

        while (queue.isNotEmpty()) {
            val (time, pos) = queue.poll()
            val (y, x) = pos

            if (y == rows - 1 && x == cols - 1) return time

            for ((dy, dx) in directions) {
                val ny = y + dy
                val nx = x + dx
                if (ny in 0 until rows && nx in 0 until cols) {
                    val newTime = maxOf(time + 1, moveTime[ny][nx] + 1)
                    if (newTime < visited[ny][nx]) {
                        visited[ny][nx] = newTime
                        queue.add(newTime to (ny to nx))
                    }
                }
            }
        }
        return 0
    }
}
