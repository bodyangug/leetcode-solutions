package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/find-the-winner-of-the-circular-game
class FindWinnerOfCircularGame {
    fun findTheWinner(n: Int, k: Int): Int {
        var winner = 0
        for (i in 1..n) {
            winner = (winner + k) % i
        }
        return winner + 1
    }
}