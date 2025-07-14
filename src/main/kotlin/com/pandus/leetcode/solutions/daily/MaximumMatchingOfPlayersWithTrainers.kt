package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-matching-of-players-with-trainers
class MaximumMatchingOfPlayersWithTrainers {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        players.sort()
        trainers.sort()

        var i = 0
        var j = 0
        var count = 0

        while (i < players.size && j < trainers.size) {
            if (players[i] <= trainers[j]) {
                count++
                i++
            }
            j++
        }

        return count
    }
}
