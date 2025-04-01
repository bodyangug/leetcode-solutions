package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/solving-questions-with-brainpower
class SolvingQuestionsWithBrainpower {
    fun mostPoints(q: Array<IntArray>): Long {
        val dp = LongArray(q.size + 1)
        for (i in q.size - 1 downTo 0) dp[i] = max(
            dp[min(q.size, i + q[i][1] + 1)] + q[i][0], dp[i + 1]
        )
        return dp[0]
    }
}
