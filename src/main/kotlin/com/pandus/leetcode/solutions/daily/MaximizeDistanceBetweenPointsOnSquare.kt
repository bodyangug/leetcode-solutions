package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square
class MaximizeDistanceBetweenPointsOnSquare {
    fun maxDistance(side: Int, points: Array<IntArray>, k: Int): Int {
        val perim = 4L * side
        // Map each point to its perimeter position
        val pos = points.map { (x, y) ->
            when {
                y == 0 -> x.toLong()                    // bottom edge
                x == side -> side.toLong() + y           // right edge
                y == side -> 3L * side - x               // top edge
                else -> 4L * side - y                    // left edge (x==0)
            }
        }.toLongArray()
        pos.sort()
        val n = pos.size

        fun canAchieve(d: Long): Boolean {
            // Try each point as starting point, greedily pick k points with gap >= d
            for (start in 0 until n) {
                var count = 1
                var last = pos[start]
                var idx = start
                for (pick in 1 until k) {
                    // Find next point with perimeter position >= last + d
                    val target = last + d
                    if (target > pos[start] + perim - d) break // wrap-around won't have room
                    var lo = idx + 1
                    var hi = start + n // virtual end (circular)
                    var best = -1
                    while (lo <= hi - 1) { // search in [lo, hi-1]
                        val mid = (lo + hi) / 2
                        val actualIdx = mid % n
                        val val_ = if (mid >= n) pos[actualIdx] + perim else pos[actualIdx]
                        if (val_ >= target) {
                            best = mid
                            hi = mid
                        } else {
                            lo = mid + 1
                        }
                    }
                    if (best == -1) break
                    val actualIdx = best % n
                    last = if (best >= n) pos[actualIdx] + perim else pos[actualIdx]
                    idx = best
                    count++
                }
                // Check wrap-around: distance from last back to start
                if (count == k) {
                    val wrapGap = pos[start] + perim - last
                    if (wrapGap >= d) return true
                }
            }
            return false
        }

        var lo = 0L
        var hi = perim / k
        while (lo < hi) {
            val mid = (lo + hi + 1) / 2
            if (canAchieve(mid)) lo = mid else hi = mid - 1
        }
        return lo.toInt()
    }
}