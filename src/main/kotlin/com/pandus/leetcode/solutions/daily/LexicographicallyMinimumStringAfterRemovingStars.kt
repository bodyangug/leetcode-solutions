package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars
class LexicographicallyMinimumStringAfterRemovingStars {
    fun clearStars(s: String): String {
        val n = s.length
        val comparator = compareBy<Pair<Char, Int>>({ it.first }, { -it.second })
        val p = PriorityQueue<Pair<Char, Int>>(comparator)
        for ((i, c) in s.withIndex()) {
            when (c) {
                '*' -> {
                    p.poll()
                }

                else -> {
                    p.add(Pair(c, i))
                }
            }
        }

        var arr = CharArray(n) { '*' }
        while (!p.isEmpty()) {
            val (c, i) = p.poll()
            arr[i] = c
        }
        return arr.filter { it != '*' }.joinToString("")
    }
}
