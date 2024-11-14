package com.pandus.leetcode.solutions.daily

import java.util.PriorityQueue
import kotlin.math.ceil


// Reference: https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store
class MinimizedMaximumOfProductsDistributedToAnyStore {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        val typeStorePairs = PriorityQueue<IntArray> { a, b ->
            (b[0] * a[1]).compareTo(a[0] * b[1])
        }

        quantities.forEach { quantity -> typeStorePairs.offer(intArrayOf(quantity, 1)) }

        repeat(n - quantities.size) {
            val (quantity, stores) = typeStorePairs.poll()
            typeStorePairs.offer(intArrayOf(quantity, stores + 1))
        }

        val (quantity, stores) = typeStorePairs.poll()
        return ceil(quantity.toDouble() / stores).toInt()
    }
}
