package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/sort-the-people
class SortThePeople {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        return names.indices
            .sortedByDescending { heights[it] }
            .map { names[it] }
            .toTypedArray()
    }
}
