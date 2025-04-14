package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/count-good-triplets
class CountGoodTriplets {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        val n = arr.size
        var cnt = 0
        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                if (abs(arr[i] - arr[j]) > a) continue
                for (k in j + 1 until n) {
                    if (abs(arr[j] - arr[k]) > b || abs(arr[i] - arr[k]) > c) continue
                    ++cnt
                }
            }
        }
        return cnt
    }
}
