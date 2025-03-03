package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/partition-array-according-to-given-pivot
class PartitionArrayAccordingToGivenPivot {
    fun pivotArray(n: IntArray, p: Int) =
        n.filter { it < p } + n.filter { it == p } + n.filter { it > p }
}
