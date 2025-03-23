package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination
class NumberOfWaysToArriveAtDestination {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val inf = Long.MAX_VALUE

        val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for ((u, v, time) in roads) {
            graph[u].add(v to time)
            graph[v].add(u to time)
        }

        val shortestTime = LongArray(n) { inf }
        val pathCount = IntArray(n)

        shortestTime[0] = 0L
        pathCount[0] = 1

        val minHeap = PriorityQueue(compareBy<Pair<Long, Int>> { it.first })
        minHeap.offer(0L to 0)

        while (minHeap.isNotEmpty()) {
            val (currTime, currNode) = minHeap.poll()

            if (currTime > shortestTime[currNode]) continue

            for ((neighborNode, roadTime) in graph[currNode]) {
                val newTime = currTime + roadTime
                if (newTime < shortestTime[neighborNode]) {
                    shortestTime[neighborNode] = newTime
                    pathCount[neighborNode] = pathCount[currNode]
                    minHeap.offer(newTime to neighborNode)
                } else if (newTime == shortestTime[neighborNode]) {
                    pathCount[neighborNode] = (pathCount[neighborNode] + pathCount[currNode]) % mod
                }
            }
        }
        return pathCount[n - 1]
    }
}
