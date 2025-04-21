package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/rabbits-in-forest
class RabbitsInForest {
    fun numRabbits(answers: IntArray): Int {
        val countMap = mutableMapOf<Int, Int>()
        for (answer in answers) {
            countMap[answer] = countMap.getOrDefault(answer, 0) + 1
        }

        return countMap.entries.sumOf { (x, count) ->
            val groupSize = x + 1
            val groups = (count + x) / groupSize
            groups * groupSize
        }
    }
}
