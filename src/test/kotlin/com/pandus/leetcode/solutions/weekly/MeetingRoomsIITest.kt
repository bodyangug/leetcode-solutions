package com.pandus.leetcode.solutions.weekly

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MeetingRoomsIITest {
    @Test
    fun minMeetingRooms_returnsCorrectRoomCount_positiveCase() {
        val solution = MeetingRoomsII()
        assertEquals(2, solution.minMeetingRooms(arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20))))
    }

    @Test
    fun minMeetingRooms_returnsZeroForEmptyIntervals_negativeCase() {
        val solution = MeetingRoomsII()
        assertEquals(0, solution.minMeetingRooms(arrayOf()))
    }
}
