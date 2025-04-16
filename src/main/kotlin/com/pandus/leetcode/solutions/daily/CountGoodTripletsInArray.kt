package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-good-triplets-in-an-array
class CountGoodTripletsInArray {
    class FenwickTree(size: Int) {
        private val tree = LongArray(size)

        fun update(index: Int, delta: Int) {
            var i = index
            while (i < tree.size) {
                tree[i] = tree[i] + delta
                i += i and -i
            }
        }

        fun query(index: Int): Long {
            var res = 0L
            var i = index
            while (i > 0) {
                res += tree[i]
                i -= i and -i
            }
            return res
        }
    }

    fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
        val n = nums1.size
        val pos = IntArray(n) { 0 }.also { p -> nums2.forEachIndexed { i, v -> p[v] = i } }
        val mapped = nums1.map { pos[it] }

        val left = LongArray(n)
        FenwickTree(n + 2).also { bit ->
            mapped.forEachIndexed { i, idx ->
                val fenwickIdx = idx + 1
                left[i] = bit.query(fenwickIdx)
                bit.update(fenwickIdx, 1)
            }
        }

        val right = LongArray(n)
        FenwickTree(n + 2).also { bit ->
            for (i in n - 1 downTo 0) {
                val fenwickIdx = mapped[i] + 1
                right[i] = bit.query(n + 1) - bit.query(fenwickIdx)
                bit.update(fenwickIdx, 1)
            }
        }

        return left.indices.sumOf { i -> left[i] * right[i] }
    }
}
