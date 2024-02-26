package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/greatest-common-divisor-traversal
class GreatestCommonDivisorTraversal {
    fun canTraverseAllPairs(nums: IntArray): Boolean {
        if (nums.size == 1) return true

        val ds = IntArray(nums.size) { it }
        val num = IntArray(nums.size) { 1 }
        val mp = mutableMapOf<Int, Int>()

        fun find(i: Int): Int = if (ds[i] == i) i else find(ds[i]).also { ds[i] = it }
        fun merge(i: Int, j: Int) {
            var (i, j) = find(i) to find(j)
            if (i == j) return
            if (num[i] < num[j]) i = j.also { j = i }
            ds[j] = i
            num[i] += num[j]
        }

        nums.forEachIndexed { i, n ->
            var n = n
            if (n == 1) return false
            (2..n).takeWhile { it * it <= n }.forEach { d ->
                if (n % d == 0) {
                    if (mp.contains(d)) merge(i, mp[d]!!) else mp[d] = i
                    while (n % d == 0) n /= d
                }
            }
            if (n > 1) if (mp.contains(n)) merge(i, mp[n]!!) else mp[n] = i
        }
        return num[find(0)] == nums.size
    }
}