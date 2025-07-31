package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/bitwise-ors-of-subarrays
class BitwiseORsOfSubarrays {
    fun subarrayBitwiseORs(A: IntArray): Int {
        val ans = HashSet<Int>()
        var prev = HashSet<Int>()

        for (x in A) {
            val cur = HashSet<Int>()
            cur.add(x)
            for (y in prev) {
                cur.add(x or y)
            }
            ans.addAll(cur)
            prev = cur
        }
        return ans.size
    }
}
