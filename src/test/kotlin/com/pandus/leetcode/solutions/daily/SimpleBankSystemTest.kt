package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SimpleBankSystemTest {
    @Test
    @DisplayName("Deposit increases balance of a valid account")
    fun deposit_basic() {
        val system = SimpleBankSystem(longArrayOf(10L, 5L))
        val result = system.deposit(1, 7L)
        assertTrue(result, "Deposit should succeed for valid account")
        assertEquals(17L, system.balance[0])
        assertEquals(5L, system.balance[1], "Other account should remain unchanged")
    }

    @Test
    @DisplayName("Withdraw decreases balance when sufficient funds exist")
    fun withdraw_basic() {
        val system = SimpleBankSystem(longArrayOf(20L))
        val result = system.withdraw(1, 8L)
        assertTrue(result, "Withdraw should succeed with enough funds")
        assertEquals(12L, system.balance[0])
    }

    @Test
    @DisplayName("Transfer moves funds between two valid accounts when source has enough")
    fun transfer_basic() {
        val system = SimpleBankSystem(longArrayOf(30L, 4L))
        val result = system.transfer(1, 2, 10L)
        assertTrue(result, "Transfer should succeed with valid accounts and sufficient funds")
        assertEquals(20L, system.balance[0])
        assertEquals(14L, system.balance[1])
    }
}
