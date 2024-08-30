package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-senior-citizens
class NumberOfSeniorCitizens {
    fun countSeniors(details: Array<String>): Int {
        return details.count { it.substring(11, 13).toInt() > 60 }
    }
}
