package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated
class CheckIfArrayIsSortedAndRotated {
    fun check(n: IntArray) = n.sorted() in n.indices.map { n.drop(it) + n.take(it) }
}
