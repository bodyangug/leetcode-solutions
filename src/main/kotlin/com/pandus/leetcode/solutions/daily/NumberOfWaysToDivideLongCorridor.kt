package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor
class NumberOfWaysToDivideLongCorridor {
    private val MOD: Int = 1000000007
    private fun count(
        index: Int,
        seats: Int,
        corridor: String,
        cache: MutableMap<Pair<Int, Int>, Int>
    ): Int {
        if (index == corridor.length) {
            return if (seats == 2) 1 else 0
        }
        if (cache.containsKey(Pair(index, seats))) {
            return cache[Pair(index, seats)]!!
        }
        val result = if (seats == 2) {
            if (corridor[index] == 'S') {
                count(index + 1, 1, corridor, cache)
            } else {
                (count(index + 1, 0, corridor, cache) + count(index + 1, 2, corridor, cache)) % MOD
            }
        } else {
            if (corridor[index] == 'S') {
                count(index + 1, seats + 1, corridor, cache)
            } else {
                count(index + 1, seats, corridor, cache)
            }
        }
        cache[Pair(index, seats)] = result
        return result
    }

    fun numberOfWays(corridor: String): Int {
        val cache: MutableMap<Pair<Int, Int>, Int> = HashMap()
        return count(0, 0, corridor, cache)
    }
}
