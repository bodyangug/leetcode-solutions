package com.pandus.leetcode.solutions.google

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueEmailAddressesTest {
    private val solution = UniqueEmailAddresses()

    @Test
    fun `should return 2 unique emails when given emails with dots and plus signs`() {
        val emails = arrayOf(
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        )
        val result = solution.numUniqueEmails(emails)
        assertEquals(2, result)
    }

    @Test
    fun `should return 0 when given empty array`() {
        val emails = arrayOf<String>()
        val result = solution.numUniqueEmails(emails)
        assertEquals(0, result)
    }

    @Test
    fun `should count emails with multiple dots as same email`() {
        val emails = arrayOf(
            "test...email@leetcode.com",
            "test.email@leetcode.com",
            "t.e.s.t.email@leetcode.com"
        )
        val result = solution.numUniqueEmails(emails)
        assertEquals(1, result)
    }

    @Test
    fun `should ignore everything after plus sign in local part`() {
        val emails = arrayOf(
            "test+alex+more@leetcode.com",
            "test+alex@leetcode.com",
            "test+more@leetcode.com"
        )
        val result = solution.numUniqueEmails(emails)
        assertEquals(1, result)
    }

    @Test
    fun `should treat same emails with different domains as unique`() {
        val emails = arrayOf(
            "test.email@leetcode.com",
            "test.email@code.com",
            "test.email@example.com"
        )
        val result = solution.numUniqueEmails(emails)
        assertEquals(3, result)
    }

    @Test
    fun `should handle emails with no special characters`() {
        val emails = arrayOf(
            "alice@leetcode.com",
            "bob@leetcode.com",
            "charlie@leetcode.com"
        )
        val result = solution.numUniqueEmails(emails)
        assertEquals(3, result)
    }

    @Test
    fun `should handle duplicate emails`() {
        val emails = arrayOf(
            "test.email@leetcode.com",
            "test.email@leetcode.com",
            "test.email@leetcode.com"
        )
        val result = solution.numUniqueEmails(emails)
        assertEquals(1, result)
    }

    @Test
    fun numUniqueEmails_handlesMixedCaseEmails() {
        val emails = arrayOf(
            "Test.Email@leetcode.com",
            "test.email@leetcode.com",
            "TEST.EMAIL@leetcode.com"
        )
        val result = solution.numUniqueEmails(emails)
        assertEquals(3, result)
    }
}
