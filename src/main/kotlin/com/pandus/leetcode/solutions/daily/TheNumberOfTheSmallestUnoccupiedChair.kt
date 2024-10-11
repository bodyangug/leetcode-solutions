package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair
class TheNumberOfTheSmallestUnoccupiedChair {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val targetTime = times[targetFriend]
        Arrays.sort(times) { a, b -> a[0].compareTo(b[0]) }
        val n = times.size
        val chairTime = IntArray(n)
        for (time in times) {
            for (i in 0 until n) {
                if (chairTime[i] <= time[0]) {
                    chairTime[i] = time[1]
                    if (time.contentEquals(targetTime)) return i
                    break
                }
            }
        }
        return 0
    }
}
