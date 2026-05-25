package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/jump-game-vii
class JumpGameVII {
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val n = s.length
        if (s[n - 1] != '0') return false

        val reachable = BooleanArray(n)
        reachable[0] = true
        var count = 0

        for (i in minJump until n) {
            if (reachable[i - minJump]) count++
            if (i > maxJump && reachable[i - maxJump - 1]) count--
            reachable[i] = count > 0 && s[i] == '0'
        }
        return reachable[n - 1]
    }
}
