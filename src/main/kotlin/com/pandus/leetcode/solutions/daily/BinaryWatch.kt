package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/binary-watch
class BinaryWatch {
    fun readBinaryWatch(turnedOn: Int): List<String> {
        val result = mutableListOf<String>()
        for (hour in 0..11) {
            for (minute in 0..59) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    result.add("$hour:${minute.toString().padStart(2, '0')}")
                }
            }
        }
        return result
    }
}
