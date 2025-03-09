package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/alternating-groups-ii
class AlternatingGroupsII {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        val length = colors.size
        var result = 0
        var alternatingElementsCount = 1
        var lastColor = colors[0]

        for (i in 1..<length + k - 1) {
            val index = i % length // Wrap around using modulo
            if (colors[index] == lastColor) {
                alternatingElementsCount = 1
                lastColor = colors[index]
                continue
            }

            alternatingElementsCount += 1

            if (alternatingElementsCount >= k) {
                result++
            }

            lastColor = colors[index]
        }

        return result
    }
}
