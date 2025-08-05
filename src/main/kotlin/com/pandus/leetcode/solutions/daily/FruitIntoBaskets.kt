package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/fruit-into-baskets
class FruitIntoBaskets {
    fun totalFruit(f: IntArray): Int {
        var p = -1
        var c = 0
        var j = 0
        return f.withIndex().maxOf { (i, t) ->
            if (t != f[j]) {
                if (t != p) c = i - j
                p = f[j]
                j = i
            }
            ++c
        }
    }
}
