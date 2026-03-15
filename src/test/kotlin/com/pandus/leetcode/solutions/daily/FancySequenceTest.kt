package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FancySequenceTest {
    @Test
    @DisplayName("Example 1: append, addAll, multAll and getIndex combined operations")
    fun example1() {
        val fancy = FancySequence()
        fancy.append(2)
        fancy.addAll(3)
        fancy.append(7)
        fancy.multAll(2)
        assertEquals(10, fancy.getIndex(0))
        fancy.addAll(3)
        fancy.append(10)
        fancy.multAll(2)
        assertEquals(26, fancy.getIndex(0))
        assertEquals(34, fancy.getIndex(1))
        assertEquals(20, fancy.getIndex(2))
    }

    @Test
    @DisplayName("getIndex returns -1 for out-of-bounds index")
    fun getIndex_outOfBounds() {
        val fancy = FancySequence()
        assertEquals(-1, fancy.getIndex(0))
        fancy.append(5)
        assertEquals(-1, fancy.getIndex(1))
        assertEquals(-1, fancy.getIndex(100))
    }

    @Test
    @DisplayName("append only without any transformations")
    fun appendOnly() {
        val fancy = FancySequence()
        fancy.append(1)
        fancy.append(2)
        fancy.append(3)
        assertEquals(1, fancy.getIndex(0))
        assertEquals(2, fancy.getIndex(1))
        assertEquals(3, fancy.getIndex(2))
    }

    @Test
    @DisplayName("addAll applies increment to all existing elements")
    fun addAllOnly() {
        val fancy = FancySequence()
        fancy.append(10)
        fancy.append(20)
        fancy.addAll(5)
        assertEquals(15, fancy.getIndex(0))
        assertEquals(25, fancy.getIndex(1))
    }

    @Test
    @DisplayName("multAll applies multiplier to all existing elements")
    fun multAllOnly() {
        val fancy = FancySequence()
        fancy.append(3)
        fancy.append(4)
        fancy.multAll(10)
        assertEquals(30, fancy.getIndex(0))
        assertEquals(40, fancy.getIndex(1))
    }

    @Test
    @DisplayName("Newly appended element is not affected by prior addAll")
    fun appendAfterAddAll() {
        val fancy = FancySequence()
        fancy.append(1)
        fancy.addAll(100)
        fancy.append(50)
        assertEquals(101, fancy.getIndex(0))
        assertEquals(50, fancy.getIndex(1))
    }

    @Test
    @DisplayName("Newly appended element is not affected by prior multAll")
    fun appendAfterMultAll() {
        val fancy = FancySequence()
        fancy.append(2)
        fancy.multAll(5)
        fancy.append(7)
        assertEquals(10, fancy.getIndex(0))
        assertEquals(7, fancy.getIndex(1))
    }

    @Test
    @DisplayName("Multiple consecutive addAll operations accumulate correctly")
    fun multipleAddAll() {
        val fancy = FancySequence()
        fancy.append(0)
        fancy.addAll(1)
        fancy.addAll(2)
        fancy.addAll(3)
        assertEquals(6, fancy.getIndex(0))
    }

    @Test
    @DisplayName("Multiple consecutive multAll operations accumulate correctly")
    fun multipleMultAll() {
        val fancy = FancySequence()
        fancy.append(1)
        fancy.multAll(2)
        fancy.multAll(3)
        fancy.multAll(4)
        assertEquals(24, fancy.getIndex(0))
    }

    @Test
    @DisplayName("Operations on a single element with mixed add and mult")
    fun singleElementMixedOps() {
        val fancy = FancySequence()
        fancy.append(1)
        fancy.addAll(2)
        fancy.multAll(3)
        fancy.addAll(4)
        assertEquals(13, fancy.getIndex(0))
    }

    @Test
    @DisplayName("Large values are handled with modular arithmetic")
    fun largeValuesModArithmetic() {
        val mod = 1_000_000_007
        val fancy = FancySequence()
        fancy.append(mod - 1)
        fancy.addAll(1)
        assertEquals(0, fancy.getIndex(0))

        val fancy2 = FancySequence()
        fancy2.append(mod - 1)
        fancy2.multAll(2)
        assertEquals((((mod - 1).toLong() * 2) % mod).toInt(), fancy2.getIndex(0))
    }
}
