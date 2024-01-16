package com.pandus.leetcode.solutions.daily

import java.util.*

//Reference: https://leetcode.com/problems/find-players-with-zero-or-one-losses
class FindPlayersWithZeroLosses {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val lossesCount: MutableMap<Int, Int> = HashMap()
        val winners = mutableListOf<Int>()
        val runnerUps = mutableListOf<Int>()

        for (match in matches) {
            val winner = match[0]
            val loser = match[1]
            lossesCount[winner] = lossesCount.getOrDefault(winner, 0)
            lossesCount[loser] = lossesCount.getOrDefault(loser, 0) + 1
        }

        lossesCount.forEach { (player, losses) ->
            when (losses) {
                0 -> winners.add(player)
                1 -> runnerUps.add(player)
            }
        }

        return listOf(winners.sorted(), runnerUps.sorted())
    }
}