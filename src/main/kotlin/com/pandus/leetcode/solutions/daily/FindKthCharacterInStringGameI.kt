package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-k-th-character-in-string-game-i
class FindKthCharacterInStringGameI {
    fun kthCharacter(k: Int): Char {
        var k = k
        var ans = 0
        var t: Int
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k)
            if ((1 shl t) == k) {
                t--
            }
            k = k - (1 shl t)
            ans++
        }
        return ('a'.code + ans).toChar()
    }
}
