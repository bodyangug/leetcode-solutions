package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/time-needed-to-buy-tickets
class TimeNeededToBuyTickets {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var ans = 0
        while (true) {
            for (index in tickets.indices) {
                if (tickets[index] == 0) continue
                tickets[index]--
                ans++
                if (tickets[k] == 0) return ans
            }
        }
    }
}
