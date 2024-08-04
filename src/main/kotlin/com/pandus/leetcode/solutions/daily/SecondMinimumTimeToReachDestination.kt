package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

//Reference: https://leetcode.com/problems/second-minimum-time-to-reach-destination
class SecondMinimumTimeToReachDestination {
    fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
        val adj: MutableMap<Int, MutableList<Int>> = HashMap()
        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]
            adj.computeIfAbsent(a) { ArrayList() }.add(b)
            adj.computeIfAbsent(b) { ArrayList() }.add(a)
        }
        val dist1 = IntArray(n + 1)
        val dist2 = IntArray(n + 1)
        val freq = IntArray(n + 1)
        // dist1[i] stores the minimum time taken to reach node i from node 1. dist2[i]
        // stores the second minimum time taken to reach node from node 1. freq[i] stores
        // the number of times a node is popped out of the heap.
        for (i in 1..n) {
            dist2[i] = Int.MAX_VALUE
            dist1[i] = dist2[i]
            freq[i] = 0
        }

        val pq = PriorityQueue { a: IntArray, b: IntArray -> (a[1] - b[1]) }
        pq.offer(intArrayOf(1, 0))
        dist1[1] = 0

        while (!pq.isEmpty()) {
            val temp = pq.poll()
            val node = temp[0]
            var time_taken = temp[1]

            freq[node]++

            // If the node is being visited for the second time and is 'n', return the
            // answer.
            if (freq[node] == 2 && node == n) return time_taken
            // If the current light is red, wait till the path turns green.
            time_taken = if ((time_taken / change) % 2 == 1) change * (time_taken / change + 1) + time
            else time_taken + time

            if (!adj.containsKey(node)) continue
            for (neighbor in adj[node]!!) {
                // Ignore nodes that have already popped out twice, we are not interested in
                // visiting them again.
                if (freq[neighbor] == 2) continue

                // Update dist1 if it's more than the current time_taken and store its value in
                // dist2 since that becomes the second minimum value now.
                if (dist1[neighbor] > time_taken) {
                    dist2[neighbor] = dist1[neighbor]
                    dist1[neighbor] = time_taken
                    pq.offer(intArrayOf(neighbor, time_taken))
                } else if (dist2[neighbor] > time_taken && dist1[neighbor] != time_taken) {
                    dist2[neighbor] = time_taken
                    pq.offer(intArrayOf(neighbor, time_taken))
                }
            }
        }
        return 0
    }
}