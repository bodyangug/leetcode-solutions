package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-time-to-make-rope-colorful
class MinimumTimeToMakeRopeColorful {
    fun minCost(colors: String, neededTime: IntArray): Int {
        var totalMinSum = 0
        var pointer = 0
        while (pointer < colors.length) {
            var toRemove = 1
            for (next in (pointer + 1)..<colors.length) {
                if (colors[pointer] != colors[next]) break
                toRemove++
            }

            if (toRemove > 1) {
                totalMinSum += findMinSum(neededTime, pointer, toRemove)
            }
            pointer += toRemove
        }
        return totalMinSum
    }

    private fun findMinSum(neededTime: IntArray, pointer: Int, toRemove: Int): Int {
        val toIndex = pointer + toRemove
        var totalSum = 0
        var maxTime = 0

        for (i in pointer..<toIndex) {
            totalSum += neededTime[i]
            maxTime = maxOf(maxTime, neededTime[i])
        }

        return totalSum - maxTime
    }
}
