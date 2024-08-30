package com.pandus.leetcode.solutions.daily

import java.util.LinkedList
import java.util.Queue

// Reference: https://leetcode.com/problems/open-the-lock
class OpenTheLock {

    fun openLock(deadends: Array<String>, target: String): Int {
        // Map the next slot digit for each current slot digit.
        val nextSlot = mapOf(
            '0' to '1',
            '1' to '2',
            '2' to '3',
            '3' to '4',
            '4' to '5',
            '5' to '6',
            '6' to '7',
            '7' to '8',
            '8' to '9',
            '9' to '0'
        )
        // Map the previous slot digit for each current slot digit.
        val prevSlot = mapOf(
            '0' to '9',
            '1' to '0',
            '2' to '1',
            '3' to '2',
            '4' to '3',
            '5' to '4',
            '6' to '5',
            '7' to '6',
            '8' to '7',
            '9' to '8'
        )

        // Set to store visited and dead-end combinations.
        val visitedCombinations: MutableSet<String> = deadends.toHashSet()
        // Queue to store combinations generated after each turn.
        val pendingCombinations: Queue<String> = LinkedList()

        // Count the number of wheel turns made.
        var turns = 0

        // If the starting combination is also a dead-end,
        // then we can't move from the starting combination.
        if (visitedCombinations.contains("0000")) {
            return -1
        }

        // Start with the initial combination '0000'.
        pendingCombinations.add("0000")
        visitedCombinations.add("0000")

        while (!pendingCombinations.isEmpty()) {
            // Explore all the combinations of the current level.
            val currLevelNodesCount = pendingCombinations.size
            for (i in 0 until currLevelNodesCount) {
                // Get the current combination from the front of the queue.
                val currentCombination = pendingCombinations.poll()

                // If the current combination matches the target,
                // return the number of turns/level.
                if (currentCombination == target) {
                    return turns
                }

                // Explore all possible new combinations by turning each wheel in both directions.
                var wheel = 0
                while (wheel < 4) {
                    // Generate the new combination by turning the wheel to the next digit.
                    var newCombination = java.lang.StringBuilder(currentCombination)
                    newCombination.setCharAt(wheel, nextSlot[newCombination[wheel]]!!)
                    // If the new combination is not a dead-end and was never visited,
                    // add it to the queue and mark it as visited.
                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString())
                        visitedCombinations.add(newCombination.toString())
                    }

                    // Generate the new combination by turning the wheel to the previous digit.
                    newCombination = java.lang.StringBuilder(currentCombination)
                    newCombination.setCharAt(wheel, prevSlot[newCombination[wheel]]!!)
                    // If the new combination is not a dead-end and is never visited,
                    // add it to the queue and mark it as visited.
                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString())
                        visitedCombinations.add(newCombination.toString())
                    }
                    wheel += 1
                }
            }
            // We will visit next-level combinations.
            turns += 1
        }
        // We never reached the target combination.
        return -1
    }
}
