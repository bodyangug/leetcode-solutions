package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/find-closest-person
class FindClosestPerson {
    fun findClosest(x: Int, y: Int, z: Int): Int {
        val dx = abs(x - z)
        val dy = abs(y - z)
        return when {
            dx < dy -> 1
            dx > dy -> 2
            else -> 0
        }
    }
}
