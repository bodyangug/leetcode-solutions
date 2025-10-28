package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MakeArrayElementsEqualToZeroTest {
    @Test
    @DisplayName("Single zero with balanced non-zeros on both sides")
    fun countValidSelections_balancedArray() {
        val solution = MakeArrayElementsEqualToZero()
        val result = solution.countValidSelections(intArrayOf(1, 0, 2, 0, 3))
        assertEquals(2, result, "Should find 2 valid selections for balanced configuration")
    }

    @Test
    @DisplayName("Multiple zeros with simple non-zero elements")
    fun countValidSelections_multipleZeros() {
        val solution = MakeArrayElementsEqualToZero()
        val result = solution.countValidSelections(intArrayOf(2, 3, 4, 0, 4, 1, 0))
        assertEquals(0, result, "Should find 0 valid selections for this configuration")
    }

    @Test
    @DisplayName("Array with single element of value 1 and one zero")
    fun countValidSelections_simpleCase() {
        val solution = MakeArrayElementsEqualToZero()
        val result = solution.countValidSelections(intArrayOf(1, 0, 2, 0, 3))
        assertEquals(2, result, "Should find 4 valid selections (both directions from zero)")
    }
}
