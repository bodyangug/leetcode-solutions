package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/mirror-distance-of-an-integer
class MirrorDistanceOfInteger {
    fun mirrorDistance(n: Int): Int {
        val s = n.toString()
        val rev = s.reversed().toInt()
        return kotlin.math.abs(n - rev)
    }
}
