package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/binary-gap
class BinaryGap {
    //    Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.
    // Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
    fun binaryGap(n: Int): Int {
        var maxDistance = 0
        var lastOnePosition = -1
        var currentPosition = 0
        var num = n

        while (num > 0) {
            if ((num and 1) == 1) { // Check if the least significant bit is 1
                if (lastOnePosition != -1) {
                    maxDistance = maxOf(maxDistance, currentPosition - lastOnePosition)
                }
                lastOnePosition = currentPosition
            }
            num = num ushr 1 // Right shift to check the next bit
            currentPosition++
        }

        return maxDistance
    }
}
