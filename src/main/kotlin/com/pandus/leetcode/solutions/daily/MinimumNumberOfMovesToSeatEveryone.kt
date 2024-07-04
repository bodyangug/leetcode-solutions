package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

//Reference: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone
class MinimumNumberOfMovesToSeatEveryone {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        var moves = 0
        for (i in seats.indices) {
            moves += abs(seats[i] - students[i])
        }
        return moves
    }
}