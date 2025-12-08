package com.pandus.leetcode.solutions.daily

import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/count-square-sum-triples
class CountSquareSumTriples {
    fun countTriples(n: Int): Int {
        var res = 0
        for (a in 1..n) {
            for (b in 1..n) {
                val c = sqrt(a * a + b * b + 1.0).toInt()
                if (c <= n && c * c == a * a + b * b) {
                    ++res
                }
            }
        }
        return res
    }
}
