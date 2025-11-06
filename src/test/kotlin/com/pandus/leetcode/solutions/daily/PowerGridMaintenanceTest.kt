package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PowerGridMaintenanceTest {

    @Test
    @DisplayName("Single component with query type 1 returns the station itself when online")
    fun singleComponent_queryType1_returnsStation() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        val queries = arrayOf(intArrayOf(1, 2))
        val result = powerGrid.processQueries(3, connections, queries)
        assertArrayEquals(intArrayOf(2), result)
    }

    @Test
    @DisplayName("Query type 2 removes station and subsequent type 1 returns smallest in component")
    fun removeStation_queryType1_returnsSmallestRemaining() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        val queries = arrayOf(
            intArrayOf(2, 2), // Remove station 2
            intArrayOf(1, 2) // Query for station 2, should return 1 (smallest in component)
        )
        val result = powerGrid.processQueries(3, connections, queries)
        assertArrayEquals(intArrayOf(1), result)
    }

    @Test
    @DisplayName("Multiple components return correct smallest station for each")
    fun multipleComponents_queryType1_returnsCorrectSmallest() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(4, 5)
        )
        val queries = arrayOf(
            intArrayOf(1, 1), // Query component {1,2}, station 1 is online
            intArrayOf(1, 5) // Query component {4,5}, station 5 is online
        )
        val result = powerGrid.processQueries(5, connections, queries)
        assertArrayEquals(intArrayOf(1, 5), result)
    }

    @Test
    @DisplayName("Isolated station returns itself when queried")
    fun isolatedStation_queryType1_returnsItself() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf<IntArray>()
        val queries = arrayOf(intArrayOf(1, 3))
        val result = powerGrid.processQueries(3, connections, queries)
        assertArrayEquals(intArrayOf(3), result)
    }

    @Test
    @DisplayName("Remove all stations from component returns -1 for queries")
    fun removeAllStations_queryType1_returnsNegativeOne() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(intArrayOf(1, 2))
        val queries = arrayOf(
            intArrayOf(2, 1), // Remove station 1
            intArrayOf(2, 2), // Remove station 2
            intArrayOf(1, 1) // Query station 1, no stations left in component
        )
        val result = powerGrid.processQueries(2, connections, queries)
        assertArrayEquals(intArrayOf(-1), result)
    }

    @Test
    @DisplayName("Complex scenario with multiple operations")
    fun complexScenario_mixedOperations_returnsCorrectResults() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        val queries = arrayOf(
            intArrayOf(1, 3), // Query station 3, online -> returns 3
            intArrayOf(2, 1), // Remove station 1
            intArrayOf(1, 1), // Query station 1, offline -> returns 2 (smallest remaining)
            intArrayOf(2, 2), // Remove station 2
            intArrayOf(1, 3), // Query station 3, online -> returns 3
            intArrayOf(2, 3), // Remove station 3
            intArrayOf(1, 4) // Query station 4, online -> returns 4
        )
        val result = powerGrid.processQueries(4, connections, queries)
        assertArrayEquals(intArrayOf(3, 2, 3, 4), result)
    }

    @Test
    @DisplayName("Large component with removals maintains correct smallest station")
    fun largeComponent_multipleRemovals_maintainsCorrectSmallest() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5)
        )
        val queries = arrayOf(
            intArrayOf(2, 1), // Remove station 1
            intArrayOf(2, 2), // Remove station 2
            intArrayOf(1, 5), // Query station 5, online -> returns 5
            intArrayOf(1, 1) // Query station 1, offline -> returns 3 (smallest remaining)
        )
        val result = powerGrid.processQueries(5, connections, queries)
        assertArrayEquals(intArrayOf(5, 3), result)
    }

    @Test
    @DisplayName("Only type 2 queries produce no results")
    fun onlyRemoveQueries_returnsEmptyArray() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(intArrayOf(1, 2))
        val queries = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(2, 2)
        )
        val result = powerGrid.processQueries(2, connections, queries)
        assertArrayEquals(intArrayOf(), result)
    }

    @Test
    @DisplayName("Disconnected components maintain independence")
    fun disconnectedComponents_maintainIndependence() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val queries = arrayOf(
            intArrayOf(2, 1), // Remove station 1 from component {1,2}
            intArrayOf(1, 2), // Query station 2 -> returns 2
            intArrayOf(1, 3), // Query station 3 from different component -> returns 3
            intArrayOf(1, 1) // Query removed station 1 -> returns 2 (smallest in its component)
        )
        val result = powerGrid.processQueries(4, connections, queries)
        assertArrayEquals(intArrayOf(2, 3, 2), result)
    }

    @Test
    @DisplayName("Star topology with center removal")
    fun starTopology_centerRemoval_affectsAllQueries() {
        val powerGrid = PowerGridMaintenance()
        val connections = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(3, 2),
            intArrayOf(3, 4),
            intArrayOf(3, 5)
        )
        val queries = arrayOf(
            intArrayOf(1, 3), // Query center station 3 -> returns 3
            intArrayOf(2, 3), // Remove center station 3
            intArrayOf(1, 5), // Query station 5 -> returns 5
            intArrayOf(1, 3) // Query removed station 3 -> returns 1 (smallest in component)
        )
        val result = powerGrid.processQueries(5, connections, queries)
        assertArrayEquals(intArrayOf(3, 5, 1), result)
    }
}
