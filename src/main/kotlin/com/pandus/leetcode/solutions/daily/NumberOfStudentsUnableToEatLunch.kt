package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch
class NumberOfStudentsUnableToEatLunch {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        var countPreferSquare = 0
        var countPreferCircle = 0
        students.forEach {
            if (it == 1) countPreferSquare++
            else countPreferCircle++
        }
        sandwiches.forEach {
            // No student wants the circle sandwich on top of the stack
            if (it == 0 && countPreferCircle == 0) return countPreferSquare;
            // No student wants the square sandwich on top of the stack
            if (it == 1 && countPreferSquare == 0) return countPreferCircle;
            if (it == 1) countPreferSquare--
            else countPreferCircle--
        }
        return 0
    }
}
