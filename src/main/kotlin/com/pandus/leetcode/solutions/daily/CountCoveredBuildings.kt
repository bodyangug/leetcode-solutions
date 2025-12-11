package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-covered-buildings
class CountCoveredBuildings {
    fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
        val rowBuildings = mutableMapOf<Int, MutableList<Int>>() // row -> sorted list of column positions
        val colBuildings = mutableMapOf<Int, MutableList<Int>>() // col -> sorted list of row positions

        // Populate the maps
        for (building in buildings) {
            val x = building[0]
            val y = building[1]
            rowBuildings.getOrPut(x) { mutableListOf() }.add(y)
            colBuildings.getOrPut(y) { mutableListOf() }.add(x)
        }

        // Sort the lists for binary search
        rowBuildings.values.forEach { it.sort() }
        colBuildings.values.forEach { it.sort() }

        var coveredCount = 0

        // Check each building
        for (building in buildings) {
            val x = building[0]
            val y = building[1]

            // Check left: any building in same row with smaller y
            val hasLeft = rowBuildings[x]?.let { cols ->
                cols.binarySearch(y).let { idx ->
                    val insertIdx = if (idx < 0) -(idx + 1) else idx
                    insertIdx > 0
                }
            } ?: false

            // Check right: any building in same row with larger y
            val hasRight = rowBuildings[x]?.let { cols ->
                cols.binarySearch(y).let { idx ->
                    val insertIdx = if (idx < 0) -(idx + 1) else idx
                    insertIdx < cols.size - 1
                }
            } ?: false

            // Check up: any building in same column with smaller x
            val hasUp = colBuildings[y]?.let { rows ->
                rows.binarySearch(x).let { idx ->
                    val insertIdx = if (idx < 0) -(idx + 1) else idx
                    insertIdx > 0
                }
            } ?: false

            // Check down: any building in same column with larger x
            val hasDown = colBuildings[y]?.let { rows ->
                rows.binarySearch(x).let { idx ->
                    val insertIdx = if (idx < 0) -(idx + 1) else idx
                    insertIdx < rows.size - 1
                }
            } ?: false

            if (hasLeft && hasRight && hasUp && hasDown) {
                coveredCount++
            }
        }
        return coveredCount
    }
}
