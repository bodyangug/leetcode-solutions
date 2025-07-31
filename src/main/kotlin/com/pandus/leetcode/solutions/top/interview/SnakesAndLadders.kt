package com.pandus.leetcode.solutions.top.interview

import java.util.LinkedList
import java.util.Queue

// Reference: https://leetcode.com/problems/snakes-and-ladders
class SnakesAndLadders {
    fun getCoordinates(s: Int, n: Int): Pair<Int, Int> {
        val quot = (s - 1) / n
        val rem = (s - 1) % n
        val row = n - 1 - quot
        val col = if (quot % 2 == 0) rem else n - 1 - rem
        return Pair(row, col)
    }

    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        val visited = BooleanArray(n * n + 1)
        val queue: Queue<Pair<Int, Int>> = LinkedList() // Pair of (square, moves)
        queue.offer(Pair(1, 0))
        visited[1] = true

        while (queue.isNotEmpty()) {
            val (s, moves) = queue.poll()
            if (s == n * n) return moves

            for (i in 1..6) {
                var next = s + i
                if (next > n * n) continue
                val (r, c) = getCoordinates(next, n)
                if (board[r][c] != -1) {
                    next = board[r][c]
                }
                if (!visited[next]) {
                    visited[next] = true
                    queue.offer(Pair(next, moves + 1))
                }
            }
        }
        return -1 // If not reachable
    }
}
