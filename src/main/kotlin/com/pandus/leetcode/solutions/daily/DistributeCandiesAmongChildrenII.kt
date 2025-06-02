package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/distribute-candies-among-children-ii
class DistributeCandiesAmongChildrenII {
    fun distributeCandies(n: Int, limit: Int): Long {
        var ans: Long = 0
        for (i in 0..min(limit, n)) {
            if (n - i > 2 * limit) {
                continue
            }
            ans += (min((n - i), limit) - max(0, (n - i - limit)) + 1)
        }
        return ans
    }
}
