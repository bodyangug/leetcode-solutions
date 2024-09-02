package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk
class FindTheStudentThatWillReplaceTheChalk {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        val totalSum = chalk.sumOf { it.toLong() }
        var remainingChalk = (k % totalSum).toInt()

        // Determine which student will use up the remaining chalk.
        for (i in chalk.indices) {
            if (remainingChalk < chalk[i]) {
                return i
            }
            remainingChalk -= chalk[i]
        }
        return 0
    }
}
