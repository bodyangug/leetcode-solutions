package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue

// Reference: https://leetcode.com/problems/ugly-number-ii
class UglyNumberII {
    fun nthUglyNumber(n: Int): Int {
        val primes = intArrayOf(2, 3, 5)
        val uglyHeap = PriorityQueue<Long>()
        val visited = HashSet<Long>()

        uglyHeap.add(1L)
        visited.add(1L)

        var curr = 1L
        for (i in 0 until n) {
            curr = uglyHeap.poll()
            for (prime in primes) {
                val newUgly = curr * prime
                if (!visited.contains(newUgly)) {
                    uglyHeap.add(newUgly)
                    visited.add(newUgly)
                }
            }
        }
        return curr.toInt()
    }
}
