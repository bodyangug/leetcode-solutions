package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-balanced-subarray-ii
class LongestBalancedSubarrayII {
    fun longestBalanced(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0

        fun sgn(x: Int) = if (x % 2 == 0) 1 else -1

        // --- Prefix sum (only first occurrence of each value contributes) ---
        val occurrences = mutableMapOf<Int, ArrayDeque<Int>>()
        val prefix = IntArray(n)
        prefix[0] = sgn(nums[0])
        occurrences.getOrPut(nums[0]) { ArrayDeque() }.addLast(1)

        for (i in 1 until n) {
            prefix[i] = prefix[i - 1]
            val occ = occurrences.getOrPut(nums[i]) { ArrayDeque() }
            if (occ.isEmpty()) prefix[i] += sgn(nums[i])
            occ.addLast(i + 1)
        }

        // --- Array-based segment tree (min/max + lazy propagation) ---
        val sz = n * 4 + 2
        val mn = IntArray(sz)
        val mx = IntArray(sz)
        val lz = IntArray(sz)

        fun pushup(i: Int) {
            mn[i] = minOf(mn[i shl 1], mn[i shl 1 or 1])
            mx[i] = maxOf(mx[i shl 1], mx[i shl 1 or 1])
        }

        fun apply(i: Int, v: Int) {
            mn[i] += v
            mx[i] += v
            lz[i] += v
        }

        fun pushdown(i: Int) {
            if (lz[i] != 0) {
                apply(i shl 1, lz[i])
                apply(i shl 1 or 1, lz[i])
                lz[i] = 0
            }
        }

        fun build(l: Int = 1, r: Int = n, i: Int = 1) {
            if (l == r) {
                mn[i] = prefix[l - 1]
                mx[i] = prefix[l - 1]
                return
            }
            val mid = (l + r) shr 1
            build(l, mid, i shl 1)
            build(mid + 1, r, i shl 1 or 1)
            pushup(i)
        }

        fun update(tl: Int, tr: Int, v: Int, l: Int = 1, r: Int = n, i: Int = 1) {
            if (tl <= l && r <= tr) {
                apply(i, v)
                return
            }
            pushdown(i)
            val mid = (l + r) shr 1
            if (tl <= mid) update(tl, tr, v, l, mid, i shl 1)
            if (tr > mid) update(tl, tr, v, mid + 1, r, i shl 1 or 1)
            pushup(i)
        }

        // Find rightmost position in [tl, tr] with value == val
        fun findLast(tl: Int, tr: Int, v: Int, l: Int = 1, r: Int = n, i: Int = 1): Int {
            if (mn[i] > v || mx[i] < v || l > tr || r < tl) return -1
            if (l == r) return l
            pushdown(i)
            val mid = (l + r) shr 1
            // Search right side first for rightmost match
            val res = findLast(tl, tr, v, mid + 1, r, i shl 1 or 1)
            return if (res != -1) res else findLast(tl, tr, v, l, mid, i shl 1)
        }

        build()

        // --- Sliding window ---
        var len = 0
        for (i in nums.indices) {
            val found = findLast(i + len, n, 0)
            if (found != -1) len = maxOf(len, found - i)

            val occ = occurrences[nums[i]]!!
            occ.removeFirst()
            val nextPos = if (occ.isNotEmpty()) occ.first() else n + 1

            update(i + 1, nextPos - 1, -sgn(nums[i]))
        }

        return len
    }
}
