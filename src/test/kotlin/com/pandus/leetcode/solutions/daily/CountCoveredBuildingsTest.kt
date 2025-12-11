package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountCoveredBuildingsTest {
    private val solver = CountCoveredBuildings()

    @Test
    @DisplayName("Example 1: Cross pattern with center covered")
    fun countCoveredBuildings_example1() {
        val n = 3
        val buildings = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 2),
            intArrayOf(3, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 3)
        )
        assertEquals(1, solver.countCoveredBuildings(n, buildings))
        // Building [2,2] is covered by [1,2] above, [3,2] below, [2,1] left, [2,3] right
    }

    @Test
    @DisplayName("Example 2: L-shape pattern with no covered buildings")
    fun countCoveredBuildings_example2() {
        val n = 3
        val buildings = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 2)
        )
        assertEquals(0, solver.countCoveredBuildings(n, buildings))
        // No building has neighbors in all four directions
    }

    @Test
    @DisplayName("Example 3: Larger grid with one covered building")
    fun countCoveredBuildings_example3() {
        val n = 5
        val buildings = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(3, 2),
            intArrayOf(3, 3),
            intArrayOf(3, 5),
            intArrayOf(5, 3)
        )
        assertEquals(1, solver.countCoveredBuildings(n, buildings))
        // Building [3,3] is covered by [1,3] above, [5,3] below, [3,2] left, [3,5] right
    }

    @Test
    @DisplayName("Edge case: Single building - not covered")
    fun countCoveredBuildings_singleBuilding() {
        val n = 3
        val buildings = arrayOf(intArrayOf(2, 2))
        assertEquals(0, solver.countCoveredBuildings(n, buildings))
        // Single building cannot be covered
    }

    @Test
    @DisplayName("Edge case: Two buildings - not covered")
    fun countCoveredBuildings_twoBuildings() {
        val n = 3
        val buildings = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2)
        )
        assertEquals(0, solver.countCoveredBuildings(n, buildings))
        // Two buildings cannot have one covered in all four directions
    }

    @Test
    @DisplayName("Edge case: Horizontal line - no covered buildings")
    fun countCoveredBuildings_horizontalLine() {
        val n = 5
        val buildings = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(3, 2),
            intArrayOf(3, 3),
            intArrayOf(3, 4),
            intArrayOf(3, 5)
        )
        assertEquals(0, solver.countCoveredBuildings(n, buildings))
        // Buildings in a horizontal line have no neighbors above or below
    }

    @Test
    @DisplayName("Edge case: Vertical line - no covered buildings")
    fun countCoveredBuildings_verticalLine() {
        val n = 5
        val buildings = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 3),
            intArrayOf(4, 3),
            intArrayOf(5, 3)
        )
        assertEquals(0, solver.countCoveredBuildings(n, buildings))
        // Buildings in a vertical line have no neighbors left or right
    }

    @Test
    @DisplayName("Multiple covered buildings in larger grid")
    fun countCoveredBuildings_multipleCovered() {
        val n = 5
        val buildings = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(2, 3),
            intArrayOf(2, 4),
            intArrayOf(3, 2),
            intArrayOf(3, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 2),
            intArrayOf(4, 3),
            intArrayOf(4, 4)
        )
        assertEquals(1, solver.countCoveredBuildings(n, buildings))
        // Building [3,3] is covered by [2,3] above, [4,3] below, [3,2] left, [3,4] right
    }

    @Test
    @DisplayName("T-shape pattern with one covered building")
    fun countCoveredBuildings_tShape() {
        val n = 4
        val buildings = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 2)
        )
        assertEquals(1, solver.countCoveredBuildings(n, buildings))
        // Building [2,2] is covered
    }

    @Test
    @DisplayName("Complex pattern with multiple covered buildings")
    fun countCoveredBuildings_complexPattern() {
        val n = 5
        val buildings = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(2, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 1),
            intArrayOf(3, 2),
            intArrayOf(3, 3),
            intArrayOf(4, 1),
            intArrayOf(4, 2),
            intArrayOf(4, 3)
        )
        assertEquals(1, solver.countCoveredBuildings(n, buildings))
        // Center building [3,2] is covered
    }
}
