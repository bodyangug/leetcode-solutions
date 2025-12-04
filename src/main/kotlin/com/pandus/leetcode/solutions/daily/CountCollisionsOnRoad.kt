package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-collisions-on-a-road
class CountCollisionsOnRoad {
    fun countCollisions(directions: String): Int {
        var ans = 0
        for (direction in directions.split("\n")) {
            var left = 0
            var right = direction.length - 1

            while (left < direction.length && direction[left] == 'L') {
                left++
            }
            while (right >= 0 && direction[right] == 'R') {
                right--
            }
            for (i in left..right) {
                if (direction[i] != 'S') {
                    ans++
                }
            }
        }
        return ans
    }
}
