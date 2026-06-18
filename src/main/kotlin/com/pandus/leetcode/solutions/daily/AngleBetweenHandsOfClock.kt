package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/angle-between-hands-of-a-clock
class AngleBetweenHandsOfClock {
    fun angleClock(hour: Int, minutes: Int): Double {
        val hourAngle = (hour % 12) * 30 + minutes * 0.5
        val minuteAngle = minutes * 6.0
        val angle = abs(hourAngle - minuteAngle)
        return angle.coerceAtMost(360 - angle)
    }
}
