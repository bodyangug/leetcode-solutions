package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-number-of-trapezoids-i
class CountNumberOfTrapezoidsI {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val pointNum: MutableMap<Int, Int> = hashMapOf()
        val mod = 1000000007
        var ans: Long = 0
        var sum: Long = 0
        for (point in points) {
            pointNum[point[1]] = pointNum.getOrDefault(point[1], 0) + 1
        }
        for (pNum in pointNum.values) {
            val edge = (pNum.toLong() * (pNum - 1)) / 2
            ans = (ans + edge * sum) % mod
            sum = (sum + edge) % mod
        }
        return ans.toInt()
    }
}
