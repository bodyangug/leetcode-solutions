package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-walls-destroyed-by-robots
class MaximumWallsDestroyedByRobots {
    fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
        val n = robots.size
        if (n == 0) return 0

        val indices = (0 until n).sortedBy { robots[it] }
        val sortedPos = IntArray(n) { robots[indices[it]] }
        val sortedDist = IntArray(n) { distance[indices[it]] }

        val sortedWalls = walls.sorted().toIntArray()
        val m = sortedWalls.size
        if (m == 0) return 0

        fun countWalls(lo: Int, hi: Int): Int {
            if (lo > hi) return 0
            val left = lowerBound(sortedWalls, lo)
            val right = upperBound(sortedWalls, hi)
            return right - left
        }

        val leftLo = IntArray(n)
        val leftHi = IntArray(n)
        val rightLo = IntArray(n)
        val rightHi = IntArray(n)

        for (i in 0 until n) {
            val pos = sortedPos[i]
            val dist = sortedDist[i]

            val lBound = if (i > 0) maxOf(pos - dist, sortedPos[i - 1] + 1) else pos - dist
            leftLo[i] = lBound
            leftHi[i] = pos

            val rBound = if (i < n - 1) minOf(pos + dist, sortedPos[i + 1] - 1) else pos + dist
            rightLo[i] = pos
            rightHi[i] = rBound
        }

        val leftCount = IntArray(n) { countWalls(leftLo[it], leftHi[it]) }
        val rightCount = IntArray(n) { countWalls(rightLo[it], rightHi[it]) }

        // overlap[i] = walls in the intersection of robot i's right range and robot i+1's left range
        // These walls would be double-counted if both fire inward.
        val overlap = IntArray(n - 1)
        for (i in 0 until n - 1) {
            val oLo = maxOf(rightLo[i], leftLo[i + 1])
            val oHi = minOf(rightHi[i], leftHi[i + 1])
            overlap[i] = countWalls(oLo, oHi)
        }

        val dp = Array(n) { IntArray(2) }
        dp[0][0] = leftCount[0]
        dp[0][1] = rightCount[0]

        for (i in 1 until n) {
            dp[i][0] = leftCount[i] + maxOf(dp[i - 1][0], dp[i - 1][1] - overlap[i - 1])
            dp[i][1] = rightCount[i] + maxOf(dp[i - 1][0], dp[i - 1][1])
        }

        return maxOf(dp[n - 1][0], dp[n - 1][1])
    }

    private fun lowerBound(arr: IntArray, target: Int): Int {
        var lo = 0
        var hi = arr.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (arr[mid] < target) lo = mid + 1 else hi = mid
        }
        return lo
    }

    private fun upperBound(arr: IntArray, target: Int): Int {
        var lo = 0
        var hi = arr.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (arr[mid] <= target) lo = mid + 1 else hi = mid
        }
        return lo
    }
}
