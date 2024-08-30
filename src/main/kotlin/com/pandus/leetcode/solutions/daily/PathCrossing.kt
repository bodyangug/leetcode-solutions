package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/path-crossing
class PathCrossing {
    fun isPathCrossing(path: String): Boolean {
        val visitedPoints = mutableSetOf(Pair(0, 0))
        var coordX = 0
        var coordY = 0
        for (c in path) {
            when (c) {
                'N' -> coordY++
                'S' -> coordY--
                'E' -> coordX++
                'W' -> coordX--
            }
            if (!visitedPoints.add(Pair(coordX, coordY))) return true
        }
        return false
    }
}
