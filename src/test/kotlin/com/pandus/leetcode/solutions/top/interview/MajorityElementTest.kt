package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {
    @Test
    fun majorityElement_returnsMajority_positiveCase() {
        val solution = MajorityElement()
        assertEquals(3, solution.majorityElement(intArrayOf(3, 2, 3)))
    }

    @Test
    fun majorityElement_returnsElementForSingleElement_negativeCase() {
        val solution = MajorityElement()
        assertEquals(1, solution.majorityElement(intArrayOf(1)))
    }
}
