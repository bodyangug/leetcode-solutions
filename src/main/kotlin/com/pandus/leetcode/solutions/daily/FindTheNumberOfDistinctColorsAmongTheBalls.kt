package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls
class FindTheNumberOfDistinctColorsAmongTheBalls {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val n = queries.size
        val result = IntArray(n)
        val colorMap: MutableMap<Int, Int> = HashMap()
        val ballMap: MutableMap<Int, Int> = HashMap()

        // Iterate through queries
        for (i in 0 until n) {
            // Extract ball label and color from query
            val ball = queries[i][0]
            val color = queries[i][1]

            // Check if ball is already colored
            if (ballMap.containsKey(ball)) {
                // Decrement count of the previous color on the ball
                val prevColor = ballMap[ball]!!
                colorMap[prevColor] = colorMap[prevColor]!! - 1

                // If there are no balls with previous color left, remove color from color map
                if (colorMap[prevColor] == 0) {
                    colorMap.remove(prevColor)
                }
            }
            // Set color of ball to the new color
            ballMap[ball] = color
            // Increment the count of the new color
            colorMap[color] = colorMap.getOrDefault(color, 0) + 1

            result[i] = colorMap.size
        }
        return result
    }
}
