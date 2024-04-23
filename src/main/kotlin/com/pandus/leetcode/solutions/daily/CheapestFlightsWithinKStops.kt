package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue


//Reference: https://leetcode.com/problems/cheapest-flights-within-k-stops
class CheapestFlightsWithinKStops {

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // 1. create map of routes
        val routes = flights.groupBy({ it[0] }, { intArrayOf(it[1], it[2]) }).mapValues { it.value.toList() }

        // 2. Create array to store all stops for each node
        val stops = IntArray(n) { Int.MAX_VALUE }
        // 3. PriorityQueue needs to store all paths for investigation
        val pq = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }
            .apply {
                this.offer(intArrayOf(0, src, 0))
            }

        //Dijkstra
        while (!pq.isEmpty()) {
            val temp = pq.poll()
            val dist = temp[0]
            val node = temp[1]
            val steps = temp[2]

            // We have already encountered a path with a lower cost and fewer stops,
            // or the number of stops exceeds the limit.
            if (steps > stops[node] || steps > k + 1) continue
            stops[node] = steps
            if (node == dst) return dist
            if (!routes.containsKey(node)) continue

            for (a in routes[node]!!) {
                pq.offer(intArrayOf(dist + a[1], a[0], steps + 1))
            }
        }
        return -1
    }

}
