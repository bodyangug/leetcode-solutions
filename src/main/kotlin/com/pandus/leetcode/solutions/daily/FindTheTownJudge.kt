package com.pandus.leetcode.solutions.daily


//Reference: https://leetcode.com/problems/find-the-town-judge
class FindTheTownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (trust.size < n - 1) {
            return -1
        }
        val trustScores = IntArray(n + 1)

        trust.forEach { relation ->
            trustScores[relation[0]]--
            trustScores[relation[1]]++
        }

        (1..n).forEach {
            if (trustScores[it] == n - 1) {
                return it
            }
        }
        return -1
    }
}
