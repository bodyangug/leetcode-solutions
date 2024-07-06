package com.pandus.leetcode.solutions.daily

//Reference:https://leetcode.com/problems/pass-the-pillow
class PassPillow {
    fun passThePillow(n: Int, time: Int): Int {
        var currentPillowPosition = 1
        var currentTime = 0
        var direction = 1
        while (currentTime < time) {
            if (currentPillowPosition + direction in 1..n) {
                currentPillowPosition += direction
                currentTime++
            } else {
                direction *= -1
            }
        }
        return currentPillowPosition
    }
}