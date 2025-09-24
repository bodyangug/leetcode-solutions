package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/fraction-to-recurring-decimal
class FractionToRecurringDecimal {
    private val DECIMAL_BASE: Long = 10L
    private val OPEN_BRACETS: String = "("
    private val CLOSE_BRACETS: String = ")"

    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator == 0) return "0"

        val sign = if ((numerator < 0) xor (denominator < 0)) "-" else ""
        val num = abs(numerator.toLong())
        val den = abs(denominator.toLong())

        val wholePart = num / den
        val remainder = num % den

        if (remainder == 0L) {
            return "$sign$wholePart"
        }

        val fractionalPart = calculateFractionalPart(remainder, den)
        return "$sign$wholePart.$fractionalPart"
    }

    private fun calculateFractionalPart(initialRemainder: Long, denominator: Long): String {
        val result = StringBuilder()
        val usedReminders = mutableMapOf<Long, Int>()
        var reminder = initialRemainder
        reminder = reminder * DECIMAL_BASE
        while (true) {
            if (usedReminders.containsKey(reminder)) {
                val periodStart = usedReminders[reminder]!!
                result.insert(periodStart, OPEN_BRACETS).append(CLOSE_BRACETS)
                break
            }

            usedReminders[reminder] = result.length
            val digit = reminder / denominator
            result.append(digit)

            val newReminder = reminder % denominator
            if (newReminder == 0L) break

            reminder = newReminder * DECIMAL_BASE
        }
        return result.toString()
    }
}
