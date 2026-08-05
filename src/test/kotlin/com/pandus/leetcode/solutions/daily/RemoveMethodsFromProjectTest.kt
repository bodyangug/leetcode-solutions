package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveMethodsFromProjectTest {
    private val solution = RemoveMethodsFromProject()

    @Test
    fun remainingMethods_example1_returnsAllMethods() {
        val invocations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(0, 1),
            intArrayOf(3, 2)
        )
        assertEquals(listOf(0, 1, 2, 3), solution.remainingMethods(4, 1, invocations).sorted())
    }

    @Test
    fun remainingMethods_example2_removesSuspiciousGroup() {
        val invocations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(0, 2),
            intArrayOf(0, 1),
            intArrayOf(3, 4)
        )
        assertEquals(listOf(3, 4), solution.remainingMethods(5, 0, invocations).sorted())
    }

    @Test
    fun remainingMethods_example3_removesAllMethods() {
        val invocations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(0, 1),
            intArrayOf(2, 0)
        )
        assertEquals(emptyList<Int>(), solution.remainingMethods(3, 2, invocations).sorted())
    }

    @Test
    fun remainingMethods_noInvocations_removesOnlyK() {
        val invocations = arrayOf<IntArray>()
        assertEquals(listOf(0, 2, 3), solution.remainingMethods(4, 1, invocations).sorted())
    }

    @Test
    fun remainingMethods_singleMethodIsBuggy_returnsEmpty() {
        val invocations = arrayOf<IntArray>()
        assertEquals(emptyList<Int>(), solution.remainingMethods(1, 0, invocations).sorted())
    }

    @Test
    fun remainingMethods_chainReachableFromK_removesWholeChain() {
        val invocations = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertEquals(emptyList<Int>(), solution.remainingMethods(4, 0, invocations).sorted())
    }

    @Test
    fun remainingMethods_outsideMethodInvokesSuspicious_returnsAll() {
        val invocations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 1)
        )
        assertEquals(listOf(0, 1, 2, 3), solution.remainingMethods(4, 1, invocations).sorted())
    }

    @Test
    fun remainingMethods_selfInvocation_removesSingleMethod() {
        val invocations = arrayOf(
            intArrayOf(2, 2)
        )
        assertEquals(listOf(0, 1, 3), solution.remainingMethods(4, 2, invocations).sorted())
    }

    @Test
    fun remainingMethods_cycleWithinSuspiciousGroup_removesGroup() {
        val invocations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1)
        )
        assertEquals(listOf(0), solution.remainingMethods(3, 1, invocations).sorted())
    }
}
