package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-laser-beams-in-a-bank
class NumberOfLaserBeamsInBank {
    fun numberOfBeams(bank: Array<String>): Int {
        var totalCountBeam = 0
        var (cur, next) = 0 to 1
        while (cur < bank.size && next < bank.size) {
            val curRow = bank[cur].count { it == '1' }
            if (curRow > 0) {
                val nextRow = bank[next].count { it == '1' }
                if (nextRow > 0) {
                    totalCountBeam += nextRow * curRow
                    cur = next
                    next++
                } else {
                    next++
                }
            } else {
                cur++
                next++
            }
        }
        return totalCountBeam
    }
}
