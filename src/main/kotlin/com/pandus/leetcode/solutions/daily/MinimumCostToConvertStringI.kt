package com.pandus.leetcode.solutions.daily

import java.util.*

//Reference:https://leetcode.com/problems/minimum-cost-to-convert-string-i
class MinimumCostToConvertStringI {
    fun minimumCost(
        source: String,
        target: String,
        original: CharArray,
        changed: CharArray,
        cost: IntArray
    ): Long {
        // Create a graph representation of character conversions
        val adjacencyList = Array(26) { mutableListOf<Pair<Int, Int>>() }

        // Populate the adjacency list with character conversions
        for (i in original.indices) {
            val from = original[i] - 'a'
            val to = changed[i] - 'a'
            adjacencyList[from].add(Pair(to, cost[i]))
        }

        // Calculate shortest paths for all possible character conversions
        val minConversionCosts = Array(26) { LongArray(26) }
        for (i in 0 until 26) {
            minConversionCosts[i] = dijkstra(i, adjacencyList)
        }

        // Calculate the total cost of converting source to target
        var totalCost = 0L
        for (i in source.indices) {
            if (source[i] != target[i]) {
                val from = source[i] - 'a'
                val to = target[i] - 'a'
                val charConversionCost = minConversionCosts[from][to]
                if (charConversionCost == -1L) {
                    return -1L // Conversion not possible
                }
                totalCost += charConversionCost
            }
        }
        return totalCost
    }

    // Find minimum conversion costs from a starting character to all other characters
    private fun dijkstra(startChar: Int, adjacencyList: Array<MutableList<Pair<Int, Int>>>): LongArray {
        // Priority queue to store characters with their conversion cost, sorted by cost
        val priorityQueue = PriorityQueue(compareBy<Pair<Long, Int>> { it.first })

        // Initialize the starting character with cost 0
        priorityQueue.add(Pair(0L, startChar))

        // Array to store the minimum conversion cost to each character
        val minCosts = LongArray(26) { -1L }

        while (priorityQueue.isNotEmpty()) {
            val (currentCost, currentChar) = priorityQueue.poll()

            if (minCosts[currentChar] != -1L && minCosts[currentChar] < currentCost) {
                continue
            }

            // Explore all possible conversions from the current character
            for ((targetChar, conversionCost) in adjacencyList[currentChar]) {
                val newTotalCost = currentCost + conversionCost

                // If we found a cheaper conversion, update its cost
                if (minCosts[targetChar] == -1L || newTotalCost < minCosts[targetChar]) {
                    minCosts[targetChar] = newTotalCost
                    // Add the updated conversion to the queue for further exploration
                    priorityQueue.add(Pair(newTotalCost, targetChar))
                }
            }
        }
        // Return the array of minimum conversion costs from the starting character to all others
        return minCosts
    }

}