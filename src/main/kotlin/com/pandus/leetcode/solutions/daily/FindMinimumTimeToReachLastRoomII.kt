package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii
class FindMinimumTimeToReachLastRoomII {
    data class Point(val y: Int, val x: Int)
    data class Node(val point: Point, val time: Int, val isEven: Boolean)

    fun minTimeToReach(grid: Array<IntArray>): Int {
        val height = grid.size
        val width = grid[0].size
        val visited = Array(height) { Array(width) { IntArray(2) { Int.MAX_VALUE } } }
        val queue = PriorityQueue<Node>(compareBy { it.time })
        val directions = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

        visited[0][0][0] = 0
        queue.add(Node(Point(0, 0), 0, true))

        while (queue.isNotEmpty()) {
            val (point, time, isEven) = queue.remove()
            val parity = if (isEven) 0 else 1
            if (time > visited[point.y][point.x][parity]) continue

            if (point.y == height - 1 && point.x == width - 1) return time

            for ((dy, dx) in directions) {
                val ny = point.y + dy
                val nx = point.x + dx
                if (ny in 0 until height && nx in 0 until width) {
                    val newTime = if (isEven)
                        maxOf(time + 1, grid[ny][nx] + 1)
                    else
                        maxOf(time + 2, grid[ny][nx] + 2)
                    if (newTime < visited[ny][nx][1 - parity]) {
                        visited[ny][nx][1 - parity] = newTime
                        queue.add(Node(Point(ny, nx), newTime, !isEven))
                    }
                }
            }
        }
        return -1
    }
}
