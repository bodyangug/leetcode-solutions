package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode
import java.lang.Integer.min

// Reference: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points
class FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    fun nodesBetweenCriticalPoints(head: ListNode): IntArray {
        var result = intArrayOf(-1, -1)
        var minDistance = Int.MAX_VALUE
        var previousNode: ListNode? = head
        var currentNode = head.next
        var currentIndex = 1
        var previousCriticalIndex = 0
        var firstCriticalIndex = 0

        while (currentNode!!.next != null) {
            if ((currentNode.`val` < previousNode!!.`val` && currentNode.`val` < currentNode.next!!.`val`) ||
                (currentNode.`val` > previousNode.`val` && currentNode.`val` > currentNode.next!!.`val`)
            ) {
                if (previousCriticalIndex == 0) {
                    previousCriticalIndex = currentIndex
                    firstCriticalIndex = currentIndex
                } else {
                    minDistance = min(minDistance, currentIndex - previousCriticalIndex)
                    previousCriticalIndex = currentIndex
                }
            }
            currentIndex++
            previousNode = currentNode
            currentNode = currentNode.next
        }

        if (minDistance != Int.MAX_VALUE) {
            val maxDistance = previousCriticalIndex - firstCriticalIndex
            result = intArrayOf(minDistance, maxDistance)
        }

        return result
    }
}
