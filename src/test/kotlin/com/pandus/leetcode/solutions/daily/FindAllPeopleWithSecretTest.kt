package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindAllPeopleWithSecretTest {
    private val solution = FindAllPeopleWithSecret()

    @Test
    fun testExample1() {
        // At time 0, person 0 shares the secret with person 1.
        // At time 5, person 1 shares the secret with person 2.
        // At time 8, person 2 shares the secret with person 3.
        // At time 10, person 1 shares the secret with person 5.
        // Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
        val n = 6
        val meetings = arrayOf(
            intArrayOf(1, 2, 5),
            intArrayOf(2, 3, 8),
            intArrayOf(1, 5, 10)
        )
        val firstPerson = 1

        val expected = listOf(0, 1, 2, 3, 5)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testExample2() {
        // At time 0, person 0 shares the secret with person 3.
        // At time 2, neither person 1 nor person 2 know the secret.
        // At time 3, person 3 shares the secret with person 0 and person 1.
        // Thus, people 0, 1, and 3 know the secret after all the meetings.
        val n = 4
        val meetings = arrayOf(
            intArrayOf(3, 1, 3),
            intArrayOf(1, 2, 2),
            intArrayOf(0, 3, 3)
        )
        val firstPerson = 3

        val expected = listOf(0, 1, 3)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testExample3() {
        // At time 0, person 0 shares the secret with person 1.
        // At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
        // Note that person 2 can share the secret at the same time as receiving it.
        // At time 2, person 3 shares the secret with person 4.
        // Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.
        val n = 5
        val meetings = arrayOf(
            intArrayOf(3, 4, 2),
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 1)
        )
        val firstPerson = 1

        val expected = listOf(0, 1, 2, 3, 4)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testNoMeetings() {
        // Only person 0 and firstPerson know the secret
        val n = 5
        val meetings = arrayOf<IntArray>()
        val firstPerson = 2

        val expected = listOf(0, 2)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testSingleMeeting() {
        // Person 0 knows secret, person 1 is firstPerson
        // Person 1 meets person 2 at time 5
        val n = 3
        val meetings = arrayOf(
            intArrayOf(1, 2, 5)
        )
        val firstPerson = 1

        val expected = listOf(0, 1, 2)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testDisconnectedMeetings() {
        // Person 0 knows secret, person 1 is firstPerson
        // Person 2 and 3 meet, but they don't know the secret
        val n = 4
        val meetings = arrayOf(
            intArrayOf(2, 3, 5)
        )
        val firstPerson = 1

        val expected = listOf(0, 1)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testMeetingsAtSameTime() {
        // Multiple meetings happening at the same time
        // Secret spreads through connected components
        val n = 6
        val meetings = arrayOf(
            intArrayOf(1, 2, 5),
            intArrayOf(2, 3, 5),
            intArrayOf(3, 4, 5)
        )
        val firstPerson = 1

        val expected = listOf(0, 1, 2, 3, 4)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testCircularMeetings() {
        // Meetings form a circle at the same time
        val n = 5
        val meetings = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 3),
            intArrayOf(3, 4, 3),
            intArrayOf(4, 1, 3)
        )
        val firstPerson = 1

        val expected = listOf(0, 1, 2, 3, 4)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testFirstPersonIsZero() {
        // Edge case: firstPerson is person 0 (who already knows the secret)
        val n = 3
        val meetings = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 2)
        )
        val firstPerson = 0

        val expected = listOf(0, 1, 2)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testLargeTimeValues() {
        // Test with large time values
        val n = 4
        val meetings = arrayOf(
            intArrayOf(1, 2, 1000000),
            intArrayOf(2, 3, 2000000)
        )
        val firstPerson = 1

        val expected = listOf(0, 1, 2, 3)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testMultipleSeparateChains() {
        // Two separate chains of meetings
        // Only the chain connected to firstPerson should know the secret
        val n = 7
        val meetings = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 2),
            intArrayOf(4, 5, 1),
            intArrayOf(5, 6, 2)
        )
        val firstPerson = 1

        val expected = listOf(0, 1, 2, 3)
        val result = solution.findAllPeople(n, meetings, firstPerson)

        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }
}
