package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/count-number-of-teams
class CountNumberOfTeams {
    fun numTeams(rating: IntArray): Int {
        val n: Int = rating.size
        var teams = 0
        val increasingCache = Array(n) { Array<Int?>(4) { null } }
        val decreasingCache = Array(n) { Array<Int?>(4) { null } }

        for (startIndex in 0 until n) {
            teams +=
                countIncreasingTeams(rating, startIndex, 1, increasingCache) +
                        countDecreasingTeams(rating, startIndex, 1, decreasingCache)
        }
        return teams
    }

    private fun countIncreasingTeams(
        rating: IntArray,
        currentIndex: Int,
        teamSize: Int,
        increasingCache: Array<Array<Int?>>
    ): Int {
        val n = rating.size

        if (currentIndex == n) return 0
        if (teamSize == 3) return 1
        increasingCache[currentIndex][teamSize]?.let { return it }

        var validTeams = 0
        for (nextIndex in currentIndex + 1 until n) {
            if (rating[nextIndex] > rating[currentIndex]) {
                validTeams += countIncreasingTeams(rating, nextIndex, teamSize + 1, increasingCache)
            }
        }
        increasingCache[currentIndex][teamSize] = validTeams
        return validTeams
    }

    private fun countDecreasingTeams(
        rating: IntArray,
        currentIndex: Int,
        teamSize: Int,
        decreasingCache: Array<Array<Int?>>
    ): Int {
        val n = rating.size
        if (currentIndex == n) return 0
        if (teamSize == 3) return 1

        decreasingCache[currentIndex][teamSize]?.let { return it }

        var validTeams = 0
        for (nextIndex in currentIndex + 1 until n) {
            if (rating[nextIndex] < rating[currentIndex]) {
                validTeams += countDecreasingTeams(rating, nextIndex, teamSize + 1, decreasingCache)
            }
        }
        decreasingCache[currentIndex][teamSize] = validTeams
        return validTeams
    }
}