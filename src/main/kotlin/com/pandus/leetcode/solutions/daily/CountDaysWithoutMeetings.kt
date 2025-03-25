package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-days-without-meetings
class CountDaysWithoutMeetings {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        var freeDays = 0
        var latestEnd = 0
        val sortedMeetings = meetings.sortedBy { it[0] }
        for ((start, end) in sortedMeetings) {
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1
            }
            latestEnd = maxOf(latestEnd, end)
        }
        freeDays += days - latestEnd
        return freeDays
    }
}
