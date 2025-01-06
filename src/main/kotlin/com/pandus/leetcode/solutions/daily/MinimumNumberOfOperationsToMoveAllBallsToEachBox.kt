package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    fun minOperations(boxes: String): IntArray {
        val answer = IntArray(boxes.length)
        for (currentBox in boxes.indices) {
            if (boxes[currentBox] == '1') {
                for (newPosition in boxes.indices) {
                    answer[newPosition] += abs((newPosition - currentBox))
                }
            }
        }
        return answer
    }
}
