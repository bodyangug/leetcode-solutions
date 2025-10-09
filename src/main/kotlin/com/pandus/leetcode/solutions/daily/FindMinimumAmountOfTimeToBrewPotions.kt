package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions
class FindMinimumAmountOfTimeToBrewPotions {
    fun minTime(skill: IntArray, mana: IntArray): Long {
        val n = skill.size
        val m = mana.size
        val times = LongArray(n)

        for (j in 0..<m) {
            var curTime: Long = 0
            for (i in 0..<n) {
                curTime =
                    max(curTime, times[i]) + skill[i].toLong() * mana[j]
            }
            times[n - 1] = curTime
            for (i in n - 2 downTo 0) {
                times[i] = times[i + 1] - skill[i + 1].toLong() * mana[j]
            }
        }
        return times[n - 1]
    }
}
