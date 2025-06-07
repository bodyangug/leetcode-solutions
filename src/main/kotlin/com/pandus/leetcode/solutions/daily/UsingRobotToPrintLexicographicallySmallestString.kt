package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string
class UsingRobotToPrintLexicographicallySmallestString {
    fun robotWithString(s: String): String {
        val cnt = IntArray(26)
        for (c in s.toCharArray()) {
            cnt[c.code - 'a'.code]++
        }

        val stack = Stack<Char?>()
        val res = StringBuilder()
        var minCharacter = 'a'
        for (c in s.toCharArray()) {
            stack.push(c)
            cnt[c.code - 'a'.code]--
            while (minCharacter != 'z' && cnt[minCharacter.code - 'a'.code] == 0) {
                minCharacter++
            }
            while (!stack.isEmpty() && stack.peek()!! <= minCharacter) {
                res.append(stack.pop())
            }
        }
        return res.toString()
    }
}
