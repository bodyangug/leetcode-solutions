package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/most-beautiful-item-for-each-query
class MostBeautifulItemForEachQuery {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        items.sortWith(compareBy({ it[0] }, { -it[1] }))
        for (i in 1..<items.size) items[i][1] = max(items[i][1], items[i - 1][1])
        return IntArray(queries.size) { i ->
            val j = items.asList().binarySearchBy(queries[i]) { it[0] }
            if (j == -1) 0 else if (j < 0) items[-j - 2][1] else items[j][1]
        }
    }
}
