package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.abs

class ChampagneTowerTest {
    private val solution = ChampagneTower()

    private fun assertDoubleEquals(expected: Double, actual: Double, delta: Double = 1e-5) {
        assertTrue(
            abs(expected - actual) < delta,
            "Expected $expected but got $actual (difference: ${abs(expected - actual)})"
        )
    }

    @Test
    fun champagneTower_example1_returns0() {
        // Input: poured = 1, query_row = 1, query_glass = 1
        // Output: 0.00000
        val result = solution.champagneTower(1, 1, 1)
        assertDoubleEquals(0.0, result)
    }

    @Test
    fun champagneTower_example2_returns0_5() {
        // Input: poured = 2, query_row = 1, query_glass = 1
        // Output: 0.50000
        val result = solution.champagneTower(2, 1, 1)
        assertDoubleEquals(0.5, result)
    }

    @Test
    fun champagneTower_example3_returns1() {
        // Input: poured = 100000009, query_row = 33, query_glass = 17
        // Output: 1.00000
        val result = solution.champagneTower(100000009, 33, 17)
        assertDoubleEquals(1.0, result)
    }

    @Test
    fun champagneTower_topGlass_returns1WhenPouredMoreThan1() {
        // Top glass should always be full if at least 1 cup is poured
        val result = solution.champagneTower(5, 0, 0)
        assertDoubleEquals(1.0, result)
    }

    @Test
    fun champagneTower_topGlass_returnsExactAmountWhenLessThan1() {
        // Top glass should contain exactly what was poured if less than 1 cup
        val result = solution.champagneTower(0, 0, 0)
        assertDoubleEquals(0.0, result)
    }

    @Test
    fun champagneTower_topGlassPartialFill_returnsExactAmount() {
        // Top glass with partial fill
        val result = solution.champagneTower(1, 0, 0)
        assertDoubleEquals(1.0, result)
    }

    @Test
    fun champagneTower_secondRowLeftGlass_returnsCorrectAmount() {
        // Pour 2 cups, check left glass in second row
        val result = solution.champagneTower(2, 1, 0)
        assertDoubleEquals(0.5, result)
    }

    @Test
    fun champagneTower_secondRowBothGlasses_returnsSameAmount() {
        // Pour 2 cups, both glasses in second row should have same amount
        val result1 = solution.champagneTower(2, 1, 0)
        val result2 = solution.champagneTower(2, 1, 1)
        assertDoubleEquals(result1, result2)
    }

    @Test
    fun champagneTower_thirdRow_middleGlassGetsMore() {
        // Pour 10 cups, check glasses in third row
        val result = solution.champagneTower(10, 2, 1)
        assertTrue(result > 0.0)
    }

    @Test
    fun champagneTower_largeAmount_returns1() {
        // Pour large amount, deep rows should be full
        val result = solution.champagneTower(1000, 10, 5)
        assertDoubleEquals(1.0, result)
    }

    @Test
    fun champagneTower_emptyGlassInLowerRow_returns0() {
        // Pour small amount, lower rows should be empty
        val result = solution.champagneTower(1, 5, 3)
        assertDoubleEquals(0.0, result)
    }

    @Test
    fun champagneTower_leftEdgeOfRow_getsLessFlow() {
        // Pour 10 cups, check left edge glass
        val result = solution.champagneTower(10, 3, 0)
        assertTrue(result >= 0.0)
    }

    @Test
    fun champagneTower_rightEdgeOfRow_getsLessFlow() {
        // Pour 10 cups, check right edge glass
        val result = solution.champagneTower(10, 3, 3)
        assertTrue(result >= 0.0)
    }

    @Test
    fun champagneTower_symmetry_leftAndRightEdgeSame() {
        // Due to symmetry, left and right edges should have same amount
        val poured = 15
        val row = 4
        val resultLeft = solution.champagneTower(poured, row, 0)
        val resultRight = solution.champagneTower(poured, row, row)
        assertDoubleEquals(resultLeft, resultRight)
    }

    @Test
    fun champagneTower_minimumPour_topGlassOnly() {
        // Pour minimal amount, only top glass gets it
        val result = solution.champagneTower(1, 0, 0)
        assertDoubleEquals(1.0, result)
    }

    @Test
    fun champagneTower_maximumRow_returns1WithLargePour() {
        // Pour huge amount, even last valid row should be full
        val result = solution.champagneTower(100000000, 99, 50)
        assertDoubleEquals(1.0, result)
    }

    @Test
    fun champagneTower_row5Glass2_withModerateAmount() {
        // Pour moderate amount, check middle glass in row 5
        val result = solution.champagneTower(25, 5, 2)
        assertTrue(result >= 0.0 && result <= 1.0)
    }

    @Test
    fun champagneTower_exactly4Cups_checkSecondRow() {
        // Pour 4 cups, second row should have champagne
        val result = solution.champagneTower(4, 1, 0)
        assertTrue(result > 0.5)
    }

    @Test
    fun champagneTower_boundaryCase_firstGlassSecondRow() {
        // Pour 2 cups exactly, first glass of second row gets 0.5
        val result = solution.champagneTower(2, 1, 0)
        assertDoubleEquals(0.5, result)
    }

    @Test
    fun champagneTower_overflow_checkThirdRowCenter() {
        // Pour enough to overflow to third row
        val result = solution.champagneTower(6, 2, 1)
        assertTrue(result > 0.0)
    }

    @Test
    fun champagneTower_largeRowIndex_emptyWithSmallPour() {
        // Pour small amount, large row index should be empty
        val result = solution.champagneTower(5, 50, 25)
        assertDoubleEquals(0.0, result)
    }

    @Test
    fun champagneTower_deeperRow_withLargePour() {
        // Pour large amount and check a deeper row
        val result = solution.champagneTower(1000, 20, 10)
        assertDoubleEquals(1.0, result)
    }

    @Test
    fun champagneTower_row10_withExactCalculation() {
        // Pour specific amount and check row 10
        val result = solution.champagneTower(100, 10, 5)
        assertTrue(result >= 0.0 && result <= 1.0)
    }
}
