package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/destroying-asteroids
class DestroyingAsteroids {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        var currentMass = mass.toLong()
        asteroids.sort()
        for (asteroid in asteroids) {
            if (currentMass < asteroid) {
                return false
            }
            currentMass += asteroid
        }
        return true
    }
}
