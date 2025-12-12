package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountMentionsPerUserTest {
    private val solution = CountMentionsPerUser()

    @Test
    @DisplayName("Example 1: id mentions with OFFLINE and HERE")
    fun testExample1() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("MESSAGE", "10", "id1 id0"),
            listOf("OFFLINE", "11", "0"),
            listOf("MESSAGE", "71", "HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(2, 2)
        assertArrayEquals(
            expected,
            result,
            "User id0 gets 1 from id mention + 1 from HERE (after coming back online), id1 gets 1 from id mention + 1 from HERE"
        )
    }

    @Test
    @DisplayName("Example 2: id mentions with OFFLINE and ALL")
    fun testExample2() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("MESSAGE", "10", "id1 id0"),
            listOf("OFFLINE", "11", "0"),
            listOf("MESSAGE", "12", "ALL")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(2, 2)
        assertArrayEquals(expected, result, "Both users get 1 from id mention + 1 from ALL (includes offline users)")
    }

    @Test
    @DisplayName("Example 3: OFFLINE user does not receive HERE mention")
    fun testExample3() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("OFFLINE", "10", "0"),
            listOf("MESSAGE", "12", "HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(0, 1)
        assertArrayEquals(
            expected,
            result,
            "id0 is offline so doesn't receive HERE mention, id1 is online and receives it"
        )
    }

    @Test
    @DisplayName("No events - all users should have 0 mentions")
    fun testNoEvents() {
        // Given
        val numberOfUsers = 3
        val events = emptyList<List<String>>()

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(0, 0, 0)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("Only ALL mentions - all users receive them regardless of status")
    fun testOnlyAllMentions() {
        // Given
        val numberOfUsers = 3
        val events = listOf(
            listOf("MESSAGE", "10", "ALL"),
            listOf("OFFLINE", "15", "1"),
            listOf("MESSAGE", "20", "ALL")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(2, 2, 2)
        assertArrayEquals(expected, result, "All users receive ALL mentions even if offline")
    }

    @Test
    @DisplayName("Multiple HERE mentions - only online users receive them")
    fun testMultipleHereMentions() {
        // Given
        val numberOfUsers = 3
        val events = listOf(
            listOf("MESSAGE", "10", "HERE"),
            listOf("OFFLINE", "15", "1"),
            listOf("MESSAGE", "20", "HERE"),
            listOf("MESSAGE", "80", "HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(3, 2, 3)
        assertArrayEquals(
            expected,
            result,
            "id0 and id2 receive all 3 HERE mentions, id1 receives first HERE then goes offline for 60s (15-75), missing second but receiving third"
        )
    }

    @Test
    @DisplayName("User goes offline and comes back before 60 seconds")
    fun testOfflineDuration() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("OFFLINE", "10", "0"),
            listOf("MESSAGE", "30", "HERE"),
            listOf("MESSAGE", "71", "HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(1, 2)
        assertArrayEquals(
            expected,
            result,
            "id0 is offline from 10 to 70, misses first HERE at 30, receives second HERE at 71 after coming back"
        )
    }

    @Test
    @DisplayName("Multiple OFFLINE events extend offline duration")
    fun testMultipleOfflineEvents() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("OFFLINE", "10", "0"),
            listOf("OFFLINE", "30", "0"),
            listOf("MESSAGE", "50", "HERE"),
            listOf("MESSAGE", "95", "HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(1, 2)
        assertArrayEquals(
            expected,
            result,
            "id0's offline extends from 10 to 90 (30+60), misses HERE at 50, receives HERE at 95"
        )
    }

    @Test
    @DisplayName("Direct id mentions work correctly")
    fun testDirectIdMentions() {
        // Given
        val numberOfUsers = 3
        val events = listOf(
            listOf("MESSAGE", "10", "id0 id2"),
            listOf("MESSAGE", "20", "id1 id0"),
            listOf("MESSAGE", "30", "id2 id2 id1")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(2, 2, 3)
        assertArrayEquals(
            expected,
            result,
            "id0 mentioned 2 times, id1 mentioned 2 times, id2 mentioned 3 times (including duplicate in last message)"
        )
    }

    @Test
    @DisplayName("Empty message content is ignored")
    fun testEmptyMessage() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("MESSAGE", "10", ""),
            listOf("MESSAGE", "20", "id0"),
            listOf("MESSAGE", "30", "   ")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(1, 0)
        assertArrayEquals(expected, result, "Empty and whitespace-only messages are ignored")
    }

    @Test
    @DisplayName("Events with same timestamp are processed in order")
    fun testSameTimestamp() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("OFFLINE", "10", "0"),
            listOf("MESSAGE", "10", "HERE"),
            listOf("MESSAGE", "71", "HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(1, 2)
        assertArrayEquals(expected, result, "OFFLINE at 10 happens before MESSAGE at 10, so id0 misses the HERE at 10")
    }

    @Test
    @DisplayName("Single user scenario")
    fun testSingleUser() {
        // Given
        val numberOfUsers = 1
        val events = listOf(
            listOf("MESSAGE", "10", "ALL"),
            listOf("MESSAGE", "20", "HERE"),
            listOf("MESSAGE", "30", "id0")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(3)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("User comes back online exactly at 60 seconds")
    fun testExactly60Seconds() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("OFFLINE", "10", "0"),
            listOf("MESSAGE", "70", "HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(1, 1)
        assertArrayEquals(expected, result, "id0 comes back online at exactly 70 (10+60), receives HERE mention")
    }

    @Test
    @DisplayName("Multiple whitespace-separated mentions in single message")
    fun testMultipleMentionsInMessage() {
        // Given
        val numberOfUsers = 3
        val events = listOf(
            listOf("MESSAGE", "10", "id0  id1   id2 ALL HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(3, 3, 3)
        assertArrayEquals(expected, result, "Each user gets: 1 id mention + 1 ALL + 1 HERE = 3")
    }

    @Test
    @DisplayName("User goes offline multiple times with non-overlapping windows")
    fun testNonOverlappingOfflineWindows() {
        // Given
        val numberOfUsers = 2
        val events = listOf(
            listOf("OFFLINE", "10", "0"),
            listOf("MESSAGE", "80", "HERE"),
            listOf("OFFLINE", "90", "0"),
            listOf("MESSAGE", "160", "HERE")
        )

        // When
        val result = solution.countMentions(numberOfUsers, events)

        // Then
        val expected = intArrayOf(2, 2)
        assertArrayEquals(
            expected,
            result,
            "id0 is online at 80 (10+60=70) and 160 (90+60=150), receives both HERE mentions"
        )
    }
}
