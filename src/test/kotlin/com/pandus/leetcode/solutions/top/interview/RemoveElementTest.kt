package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveElementTest {
    @Test
    fun removeElement_removesElement_positiveCase() {
        val nums = intArrayOf(3, 2, 2, 3)
        val solution = RemoveElement()
        val k = solution.removeElement(nums, 3)
        assertEquals(2, k)
    }

    @Test
    fun removeElement_handlesNoMatch_negativeCase() {
        val nums = intArrayOf(1, 2, 3)
        val solution = RemoveElement()
        val k = solution.removeElement(nums, 4)
        assertEquals(3, k)
    }
}
