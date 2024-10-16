package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/longest-happy-string
class LongestHappyString {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val maxHeap = PriorityQueue<Pair<Char, Int>>(compareByDescending { it.second })
        if (a > 0) maxHeap.add(Pair('a', a))
        if (b > 0) maxHeap.add(Pair('b', b))
        if (c > 0) maxHeap.add(Pair('c', c))

        val result = StringBuilder()

        while (maxHeap.isNotEmpty()) {
            val (char1, count1) = maxHeap.poll()

            val len = result.length
            if (len >= 2 && result[len - 1] == char1 && result[len - 2] == char1) {
                if (maxHeap.isEmpty()) break

                val (char2, count2) = maxHeap.poll()
                result.append(char2)

                if (count2 - 1 > 0) {
                    maxHeap.add(Pair(char2, count2 - 1))
                }
                maxHeap.add(Pair(char1, count1))
            } else {
                result.append(char1)
                if (count1 - 1 > 0) {
                    maxHeap.add(Pair(char1, count1 - 1))
                }
            }
        }
        return result.toString()
    }
}
