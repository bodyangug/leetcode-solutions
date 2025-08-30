package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/alice-and-bob-playing-flower-game
class AliceAndBobPlayingFlowerGame {
    fun flowerGame(n: Int, m: Int): Long {
        return (m.toLong() * n) / 2
    }
}
