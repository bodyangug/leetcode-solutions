package com.pandus.leetcode.solutions.daily

import java.util.*


//Reference: https://leetcode.com/problems/meeting-rooms-iii
class MeetingRooms3 {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val roomAvailabilityTime = LongArray(n)
        val meetingCount = IntArray(n)

        meetings.sortBy { it[0] }

        meetings.forEach { meeting ->
            val start = meeting[0]
            val end = meeting[1]

            var foundUnusedRoom = false
            var minAvailableTimeRoom = 0
            roomAvailabilityTime.withIndex().minByOrNull { it.value }?.also {
                minAvailableTimeRoom = it.index
            }?.value ?: Long.MAX_VALUE

            for (i in 0 until n) {
                if (roomAvailabilityTime[i] <= start) {
                    foundUnusedRoom = true
                    meetingCount[i]++
                    roomAvailabilityTime[i] = end.toLong()
                    break
                }
            }

            if (!foundUnusedRoom) {
                roomAvailabilityTime[minAvailableTimeRoom] += (end - start).toLong()
                meetingCount[minAvailableTimeRoom]++
            }
        }

        return meetingCount.withIndex().maxByOrNull { it.value }?.index ?: 0
    }
}