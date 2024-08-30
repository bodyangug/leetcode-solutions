package com.pandus.leetcode.solutions.daily

import java.lang.Integer.max
import java.lang.Integer.min

// Reference: https://leetcode.com/problems/filling-bookcase-shelves
class FillingBookcaseShelves {
    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
        val dp = IntArray(books.size + 1)

        dp[0] = 0
        dp[1] = books[0][1]

        for (i in 2..books.size) {
            var remainingShelfWidth = shelfWidth - books[i - 1][0]
            var maxHeight = books[i - 1][1]
            dp[i] = books[i - 1][1] + dp[i - 1]

            var j = i - 1
            while (j > 0 && remainingShelfWidth - books[j - 1][0] >= 0) {
                maxHeight = max(maxHeight, books[j - 1][1])
                remainingShelfWidth -= books[j - 1][0]
                dp[i] = min(dp[i], maxHeight + dp[j - 1])
                j--
            }
        }

        return dp[books.size]
    }
}
