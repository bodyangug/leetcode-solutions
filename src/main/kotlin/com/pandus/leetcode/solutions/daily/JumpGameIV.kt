package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/jump-game-iv
class JumpGameIV {
    fun minJumps(arr: IntArray): Int {
        val n = arr.size
        if (n <= 1) return 0

        val graph = mutableMapOf<Int, MutableList<Int>>()
        for (i in arr.indices) {
            graph.computeIfAbsent(arr[i]) { mutableListOf() }.add(i)
        }

        val visited = BooleanArray(n)
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        queue.add(Pair(0, 0))
        visited[0] = true

        while (queue.isNotEmpty()) {
            val (index, jumps) = queue.removeFirst()

            if (index == n - 1) return jumps

            // Jump to the same value indices
            graph[arr[index]]?.forEach { nextIndex ->
                if (!visited[nextIndex]) {
                    visited[nextIndex] = true
                    queue.add(Pair(nextIndex, jumps + 1))
                }
            }
            graph.remove(arr[index]) // Avoid future redundant checks

            // Jump to adjacent indices
            listOf(index - 1, index + 1).forEach { nextIndex ->
                if (nextIndex in 0 until n && !visited[nextIndex]) {
                    visited[nextIndex] = true
                    queue.add(Pair(nextIndex, jumps + 1))
                }
            }
        }
        return -1 // If we can't reach the end
    }
}
