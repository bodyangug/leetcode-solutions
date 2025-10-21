// filepath: /Users/bo/Documents/my-projects/leetcode-solutions/src/test/kotlin/com/pandus/leetcode/solutions/daily/MaximumFrequencyOfElementAfterPerformingOperationsITest.kt
package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumFrequencyOfElementAfterPerformingOperationsITest {
    private val solver = MaximumFrequencyOfElementAfterPerformingOperationsI()

    @Test
    fun basicExamples() {
        assertEquals(0, solver.maxFrequency(intArrayOf(), 3, 5))
        assertEquals(1, solver.maxFrequency(intArrayOf(10), 0, 0))
        assertEquals(
            3,
            solver.maxFrequency(intArrayOf(1, 2, 3), 1, 2)
        ) // target 2: all within distance after 2 operations
    }

    @Test
    fun allSameAlready() {
        val arr = intArrayOf(7, 7, 7, 7, 7)
        assertEquals(5, solver.maxFrequency(arr, 3, 2)) // already max
    }

    @Test
    fun largeKFullyCovers() {
        val arr = intArrayOf(10, 100, 1000)
        // k big enough that any can become any common value, answer limited by existing max + numOperations capped by array size
        assertEquals(3, solver.maxFrequency(arr.clone(), 2000, 2))
    }
}
