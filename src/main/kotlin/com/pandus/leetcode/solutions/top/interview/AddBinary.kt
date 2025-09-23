package com.pandus.leetcode.solutions.top.interview

// Reference: https://leetcode.com/problems/add-binary
class AddBinary {
    fun addBinary(a: String, b: String): String {
        return (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
    }
}
