package com.pandus.advent.of.code.twenty.five

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day10Test {
    private val day10 = Day10()

    // Star 1 Tests - Light Diagram Configuration

    @Test
    fun `star1 - should solve first machine with 2 button presses`() {
        val input = listOf("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}")
        val result = day10.star1(input)
        assertEquals(2, result, "First machine requires minimum 2 button presses")
    }

    @Test
    fun `star1 - should solve second machine with 3 button presses`() {
        val input = listOf("[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}")
        val result = day10.star1(input)
        assertEquals(3, result, "Second machine requires minimum 3 button presses")
    }

    @Test
    fun `star1 - should solve third machine with 2 button presses`() {
        val input = listOf("[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}")
        val result = day10.star1(input)
        assertEquals(2, result, "Third machine requires minimum 2 button presses")
    }

    @Test
    fun `star1 - should solve all three example machines with total 7 presses`() {
        val input = listOf(
            "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}",
            "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}",
            "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}"
        )
        val result = day10.star1(input)
        assertEquals(7, result, "Total button presses for all three machines should be 7 (2+3+2)")
    }

    @Test
    fun `star1 - should handle simple single light configuration`() {
        val input = listOf("[#] (0) {1}")
        val result = day10.star1(input)
        assertEquals(1, result, "Single light requiring one press")
    }

    @Test
    fun `star1 - should handle already configured machine`() {
        val input = listOf("[.] (0) {1}")
        val result = day10.star1(input)
        assertEquals(0, result, "Machine already in correct state (all lights off)")
    }

    @Test
    fun `star1 - should handle multiple lights with XOR logic`() {
        val input = listOf("[##] (0) (1) {1,2}")
        val result = day10.star1(input)
        assertEquals(2, result, "Two separate lights requiring separate presses")
    }

    // Star 2 Tests - Joltage Counter Configuration

    @Test
    fun `star2 - should solve first machine with 10 button presses`() {
        val input = listOf("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}")
        val result = day10.star2(input)
        assertEquals(10, result, "First machine counters require minimum 10 button presses")
    }

    @Test
    fun `star2 - should solve second machine with 12 button presses`() {
        val input = listOf("[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}")
        val result = day10.star2(input)
        assertEquals(12, result, "Second machine counters require minimum 12 button presses")
    }

    @Test
    fun `star2 - should solve third machine with 11 button presses`() {
        val input = listOf("[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}")
        val result = day10.star2(input)
        assertEquals(11, result, "Third machine counters require minimum 11 button presses")
    }

    @Test
    fun `star2 - should solve all three example machines with total 33 presses`() {
        val input = listOf(
            "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}",
            "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}",
            "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}"
        )
        val result = day10.star2(input)
        assertEquals(33, result, "Total button presses for all three machines should be 33 (10+12+11)")
    }

    @Test
    fun `star2 - should handle simple single counter increment`() {
        val input = listOf("[.] (0) {5}")
        val result = day10.star2(input)
        assertEquals(5, result, "Single counter requiring 5 presses")
    }

    @Test
    fun `star2 - should handle already satisfied counters`() {
        val input = listOf("[.] (0) {0}")
        val result = day10.star2(input)
        assertEquals(0, result, "Counter already at target (0)")
    }

    @Test
    fun `star2 - should handle multiple counters with shared button`() {
        val input = listOf("[..] (0,1) {3,3}")
        val result = day10.star2(input)
        assertEquals(3, result, "Two counters both incremented by same button 3 times")
    }

    @Test
    fun `star2 - should handle multiple counters with different targets`() {
        val input = listOf("[...] (0) (1) (2) {2,3,4}")
        val result = day10.star2(input)
        assertEquals(9, result, "Three separate counters requiring 2+3+4=9 presses")
    }

    @Test
    fun `star2 - should handle overlapping buttons efficiently`() {
        val input = listOf("[...] (0,1) (1,2) {2,4,2}")
        val result = day10.star2(input)
        assertEquals(4, result, "Should find optimal combination with overlapping buttons")
    }

    // Parsing Tests

    @Test
    fun `should parse machine with light diagram`() {
        val input = listOf("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}")
        val machines = input.map { line ->
            val lightDiagram = line.substringAfter("[").substringBefore("]").map { if (it == '#') 1 else 0 }
            val buttonSchematics =
                Regex("""\((.*?)\)""").findAll(line)
                    .map { it.groupValues[1].split(",").map { el -> el.toInt() } }
                    .toList()
            val joltageRequirements = line.substringAfter("{").substringBefore("}").split(",").map { it.toInt() }
            Day10.Machine(lightDiagram, buttonSchematics, joltageRequirements)
        }

        assertEquals(1, machines.size)
        assertEquals(listOf(0, 1, 1, 0), machines[0].lightDiagram)
        assertEquals(6, machines[0].buttonSchematics.size)
        assertEquals(listOf(3), machines[0].buttonSchematics[0])
        assertEquals(listOf(1, 3), machines[0].buttonSchematics[1])
        assertEquals(listOf(3, 5, 4, 7), machines[0].joltageRequirements)
    }

    @Test
    fun `should parse machine with complex button schematics`() {
        val input = listOf("[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}")
        val machines = input.map { line ->
            val lightDiagram = line.substringAfter("[").substringBefore("]").map { if (it == '#') 1 else 0 }
            val buttonSchematics =
                Regex("""\((.*?)\)""").findAll(line)
                    .map { it.groupValues[1].split(",").map { el -> el.toInt() } }
                    .toList()
            val joltageRequirements = line.substringAfter("{").substringBefore("}").split(",").map { it.toInt() }
            Day10.Machine(lightDiagram, buttonSchematics, joltageRequirements)
        }

        assertEquals(1, machines.size)
        assertEquals(listOf(0, 0, 0, 1, 0), machines[0].lightDiagram)
        assertEquals(5, machines[0].buttonSchematics.size)
        assertEquals(listOf(0, 2, 3, 4), machines[0].buttonSchematics[0])
        assertEquals(listOf(2, 3), machines[0].buttonSchematics[1])
        assertEquals(listOf(7, 5, 12, 7, 2), machines[0].joltageRequirements)
    }

    @Test
    fun `star2 - should handle large counter values`() {
        val input = listOf("[.] (0) {100}")
        val result = day10.star2(input)
        assertEquals(100, result, "Should handle large counter values efficiently")
    }
}
