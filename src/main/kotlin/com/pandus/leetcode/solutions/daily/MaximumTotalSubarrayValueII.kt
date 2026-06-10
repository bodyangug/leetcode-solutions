package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-total-subarray-value-ii
class MaximumTotalSubarrayValueII {
    fun maxTotalValue(nums: IntArray, k: Int): Long {
        val n = nums.size
        // Build sparse tables for O(1) range max / min queries.
        val logTable = IntArray(n + 1)
        for (i in 2..n) logTable[i] = logTable[i / 2] + 1
        val kMax = logTable[n] + 1
        val stMax = Array(kMax) { IntArray(n) }
        val stMin = Array(kMax) { IntArray(n) }
        for (i in 0 until n) {
            stMax[0][i] = nums[i]
            stMin[0][i] = nums[i]
        }
        var j = 1
        while ((1 shl j) <= n) {
            val len = 1 shl j
            val half = len shr 1
            for (i in 0..n - len) {
                stMax[j][i] = maxOf(stMax[j - 1][i], stMax[j - 1][i + half])
                stMin[j][i] = minOf(stMin[j - 1][i], stMin[j - 1][i + half])
            }
            j++
        }

        fun rangeValue(l: Int, r: Int): Int {
            if (l == r) return 0
            val p = logTable[r - l + 1]
            val len = 1 shl p
            val mx = maxOf(stMax[p][l], stMax[p][r - len + 1])
            val mn = minOf(stMin[p][l], stMin[p][r - len + 1])
            return mx - mn
        }

        // Encode (l, r) as a single Long key for the visited set.
        fun key(l: Int, r: Int): Long = l.toLong() * n + r

        // Max-heap on subarray value; ties broken arbitrarily.
        val heap = java.util.PriorityQueue<LongArray>(compareByDescending { it[0] })
        val seen = HashSet<Long>()
        heap.add(longArrayOf(rangeValue(0, n - 1).toLong(), 0, (n - 1).toLong()))
        seen.add(key(0, n - 1))

        var total = 0L
        var taken = 0
        while (taken < k && heap.isNotEmpty()) {
            val top = heap.poll()
            total += top[0]
            taken++
            val l = top[1].toInt()
            val r = top[2].toInt()
            if (l + 1 <= r) {
                val nk = key(l + 1, r)
                if (seen.add(nk)) {
                    heap.add(longArrayOf(rangeValue(l + 1, r).toLong(), (l + 1).toLong(), r.toLong()))
                }
            }
            if (l <= r - 1) {
                val nk = key(l, r - 1)
                if (seen.add(nk)) {
                    heap.add(longArrayOf(rangeValue(l, r - 1).toLong(), l.toLong(), (r - 1).toLong()))
                }
            }
        }
        return total
    }
}
