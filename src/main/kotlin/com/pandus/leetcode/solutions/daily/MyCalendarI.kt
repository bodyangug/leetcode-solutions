package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/my-calendar-i
class MyCalendarI(
    private val calendar: MutableList<IntArray> = ArrayList()
) {
    fun book(start: Int, end: Int): Boolean {
        for (iv in calendar) {
            if (iv[0] < end && start < iv[1]) {
                return false
            }
        }
        calendar.add(intArrayOf(start, end))
        return true
    }
}
